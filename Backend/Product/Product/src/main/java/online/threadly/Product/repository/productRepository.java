package online.threadly.Product.repository;

import online.threadly.Product.model.product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface productRepository  extends JpaRepository<product, UUID> {

    Optional<product> findBySlug(String slug);
}
