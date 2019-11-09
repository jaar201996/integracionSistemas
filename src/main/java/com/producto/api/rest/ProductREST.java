package com.producto.api.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.producto.api.dao.ProductsDAO;
import com.producto.api.entity.Product;



@RestController
@RequestMapping("products")
public class ProductREST {
	
	@Autowired
	private ProductsDAO productDAO;
	
	@RequestMapping(value= "{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("bhbhnb") Long productId) {
		
		Optional<Product> optionalProduct=productDAO.findById(productId);
		
		if(optionalProduct.isPresent()) {
			 String data = ResponseEntity.ok(optionalProduct.get());
			 return "{\"data\":" + data + "}";
		}else {
		    return ResponseEntity.noContent().build();
		}
	}
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getProduct() {
		List<Product> products=productDAO.findAll();
		/*Product product = new Product();
	    product.setId(1L);
	    product.setName("Producto 1");*/
	    return ResponseEntity.ok(products);
	}
	
	
	
	@PostMapping
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product newproduct=productDAO.save(product);
		return ResponseEntity.ok(newproduct);
	}
	
	
	@DeleteMapping(value="{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
		productDAO.deleteById(productId);
		return ResponseEntity.ok(null);
	}
	
	
	@PutMapping()
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		
		Optional<Product> optionalProduct=productDAO.findById(product.getId());
		if(optionalProduct.isPresent()) {
			Product productupdate =optionalProduct.get();
			productupdate.setV_nombreProducto(product.getV_nombreProducto());
			productupdate.setI_stockProducto(product.getI_stockProducto());
			productupdate.setV_marcaProducto(product.getV_marcaProducto());
			productDAO.save(productupdate);
			return ResponseEntity.ok(productupdate);
			
		}else {
		    return ResponseEntity.notFound().build();
		}
	}
	
	

}
