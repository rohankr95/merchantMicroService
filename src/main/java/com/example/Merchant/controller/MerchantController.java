package com.example.Merchant.controller;

import com.example.Merchant.dto.Product;
import com.example.Merchant.dto.ProductDto;
import com.example.Merchant.dto.RegisterData;
import com.example.Merchant.entity.*;
import com.example.Merchant.service.MerchantService;
import com.example.Merchant.service.ProdDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping(value="/merchant")
public class MerchantController {
    @Autowired
    MerchantService merchantService;
    @Autowired
    ProdDetailsService prodDetailsService;

     RestTemplate restTemplate=new RestTemplate();

     //===================== MERCHANT CRUD==================
    @GetMapping(value = "/{id}")
    public Merchant get(@PathVariable(name = "id") String id) {
        return merchantService.get(id);
    }

    @PostMapping
    public Merchant save(@RequestBody Merchant merchant) {
        System.out.println("in save of post");
        return merchantService.save(merchant);

    }


    @PutMapping(value = "/{id}")
    public Merchant update(@PathVariable(name = "id") String id, @RequestBody Merchant merchant) {
        Merchant e = this.get(id);
        if (e != null) {
            e.setMerchantId(merchant.getMerchantId());
            e.setRatings(merchant.getRatings()); // change it later as merchant should not be able to edit his ratings
            e.setTotalProductsAvailble(merchant.getTotalProductsAvailble());
            if (e.getName() != null) {
                e.setName(merchant.getName());
            } else if (merchant.getUsername() != null) {
                e.setUsername(merchant.getUsername());
            }
            if (merchant.getImage() != null) {
                e.setImage(merchant.getImage());
            }
            if (merchant.getProductsMap() != null) {
                e.setProductsMap(merchant.getProductsMap());
            }
        } else {
            System.out.println("The object doesn't exist");
            return null;
        }
        return merchantService.save(e);
    }

    @DeleteMapping(value = "/{mid}")
    public void delete(@PathVariable(name = "mid") String mid) {
        merchantService.delete(mid);
    }
//========================= Merchant Products CRUD ===========

    @GetMapping(value = "/{mId}/products/{pId}")
    public ProdDetails getProd(@PathVariable(name = "mId") String mId, @PathVariable(name = "pId") String pId) {
        Merchant e = merchantService.get(mId);
        if (e != null) {
            return e.getProductsMap().get(pId);
        } else {
            System.out.println("Merchant doesn't exists");
            return null;
        }

    }



    @PostMapping(value = "/{mId}/addProduct")
    public void addProducts(@PathVariable(name = "mId") String mId, @RequestBody ProductDto product) {
        Merchant m = merchantService.get(mId);
        if(m!=null){
            Product sendProduct = new Product();
            sendProduct.setProductName(product.getProductName());
            sendProduct.setProductQuantity(product.getProductQuantity());
            sendProduct.setProductPrice(product.getProductPrice());
            sendProduct.setProductImage(product.getProductImage());
            sendProduct.setProductCategory(product.getProductCategory());


            HttpEntity<Product> request = new HttpEntity<>(sendProduct);
            Product responseEntity = restTemplate.postForObject("http://localhost:8083/product"+"/"+mId,request,Product.class);

ProdDetails pd = new ProdDetails();
pd.setAvailble(product.getAvailble());
pd.setRatings(product.getRatings());
pd.setSold(product.getSold());
            System.out.println(responseEntity.getProductId());//erase it later
            m.getProductsMap().put(responseEntity.getProductId(),pd);
            merchantService.save(m);
        }else{
            System.out.println("Merchant doesn't exist");
        }


//            check if the merchant is logged in
//            no => redirect to login
//            yes ==> call the addProduct service of the PRODUCT micro service and get the id of the product in ( String prodId )and add it to the
//             and enter the prod details  ..Make sure if the product name matches then return the id of the existing prod. and inc . quantity there



//            make a new object and store price quantity etc of the product in the prodDetails and map the put(prodid, newobj)

//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            HttpEntity<Object> requestEntity = new HttpEntity<>(sendProduct,headers);

            /*ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8083/product",
                    HttpMethod.POST,
                    requestEntity,
                    String.class);*/



    }


//    @PutMapping(value = "{mId}/updateProduct/{pId}")
//    public void updateProducts(@PathVariable(name = "mId") String mId, @PathVariable(name = "pId") String pId, @RequestBody ProductContainer productContainer) {
//        Merchant e = this.get(mId);
//        if (e != null) {
//            //check if the merchant is logged in
//            //no => redirect to login
//
//            String productIdToBeUpdated = "to be updated product id";
//            ProdDetails p = e.getProductsMap().get(productIdToBeUpdated);
//            //in ui only price and availability should be editable
//            ProdDetails pd = new ProdDetails();
//            pd.setProdDetailsId(p.getProdDetailsId());
//            pd.setRatings(p.getRatings());
//            pd.setAvailble(p.getAvailble());
//            pd.setSold(p.getSold());
//            prodDetailsService.save(pd);
//            //yes ==>>>>>
//
//
//        }
//    }


    @DeleteMapping(value = "{mId}/deleteProducts/{pId}")
    public void deleteProducts(@PathVariable(name = "mId") String mId, @PathVariable(name = "pId") String pId) {
        Merchant e = this.get(mId);
        if (e != null) {
            // call product api to decrease that much count and delete the merchant name from that product
            e.getProductsMap().remove(pId);


        }
    }

    //Merchant get his particular products


//    @PostMapping("/route2")
//    public void registerMerchant(@RequestBody MerchantPass merchant) {
//        System.out.println("REgister in route2");
////
//    }




// =================== Register Auth ==================
    @PostMapping(value="/register")
    public void merchantRegister(@RequestBody RegisterData m ){

        //in credentials table of auth service
//        RegisterData data= new RegisterData();
//        data.setUsername(m.getUsername());
//        data.setPassword(m.getPassword());
//        data.setUsername(m.getUsername());


        HttpEntity<RegisterData> request = new HttpEntity<>(m);
        RegisterData responseEntity = restTemplate.postForObject("http://localhost:8084/auth/merchant/register",request,RegisterData.class);
        System.out.println("Merchant is registered");
        // making a new merchant with another data
//        merchantService.save(m);
    }


    @PostMapping(value="/login")
    public void merchantLogin(@RequestBody RegisterData m ){
//        RegisterData data= new RegisterData();
//        data.setUsername(m.getUsername());
//        data.setPassword(m.getPassword());
//data.setUsername(m.getUsername());

        HttpEntity<RegisterData> request = new HttpEntity<>(m);
        RegisterData responseEntity = restTemplate.postForObject("http://localhost:8084/auth/merchant/login",request,RegisterData.class);
       //if response is +ve then login
        System.out.println("Merchant is logggedIn");
        //if response negative send him again to login

    }
}
