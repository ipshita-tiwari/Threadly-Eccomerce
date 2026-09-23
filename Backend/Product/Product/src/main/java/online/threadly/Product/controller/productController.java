package online.threadly.Product.controller;

import online.threadly.Product.dao.Response;
import online.threadly.Product.model.product;
import online.threadly.Product.service.productService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")

public class productController {

    @Autowired
    private productService productservice;
    @GetMapping("/products")
    public List<product> getProducts(){

        return productservice.getProducts();
    }
    @PostMapping("/admin/products")
    public ResponseEntity<Response> createProduct( @RequestBody product Product ){
        product newProduct=productservice.createProduct(Product);
        if(Product==null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("Product not Created", null));
        }
        return ResponseEntity.ok(new Response("Product Created " , newProduct));

    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Response> getProducts(@PathVariable UUID  id){
        product Product =productservice.getProducts(id);
        if(Product==null) {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Product not found", null));
        }
        return ResponseEntity.ok(new Response("Product found " , Product));
    }
    @GetMapping("/products/slug/{slug}")
    public ResponseEntity<Response> getProducts(@PathVariable   String slug ){
        product Product=productservice.getProducts(slug);
        if(Product==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Response("Product not found ", null));
        }
        return  ResponseEntity.ok(new Response("Product found " , Product));
    }

    @PutMapping("/admin/products/{id}")
    public product updateProduct(@PathVariable UUID id , @RequestBody product Product){
         return  productservice.updateProduct(id, Product);
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable UUID id){
         productservice.deleteProduct(id);

    }


}
