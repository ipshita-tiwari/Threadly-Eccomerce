package online.threadly.Product.service;

import online.threadly.Product.model.product;
import online.threadly.Product.repository.productRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class productService {
    @Autowired
    private productRepository productrepository;

    public  List<product> getProducts(){
        return productrepository.findAll();
    }

    public product createProduct(product Product){
        return productrepository.save(Product);
    }

    public product getProducts(UUID id){

        return productrepository.findById(id).orElse(null);
    }

    public product getProducts(String slug){
        return productrepository.findBySlug(slug).orElse(null);
    }

    public product updateProduct( UUID id , product Product){
        product existingProduct=productrepository.findById(id).orElse(null);
        if(existingProduct==null) return null;

        existingProduct.setName(Product.getName());
        existingProduct.setSlug(Product.getSlug());
        existingProduct.setImages(Product.getImages());
        existingProduct.setBrand(Product.getBrand());
        existingProduct.setDescription(Product.getDescription());
        existingProduct.setStock(Product.getStock());
        existingProduct.setPrice(Product.getPrice());
        existingProduct.setRating(Product.getRating());
        existingProduct.setRatingCount(Product.getRatingCount());
        existingProduct.setIsFeatured(Product.getIsFeatured());


        return productrepository.save(existingProduct);

    }

    public void deleteProduct(UUID id){
        if(productrepository.existsById(id)) {
            productrepository.deleteById(id);
        }
    }




}
