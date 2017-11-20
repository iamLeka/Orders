package be.cegeka.orders.order.domain.orders;


import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

@Named
public class SupplierService {



    private RestTemplate restTemplate;

    public void postNewOrder(String consumerName, String detailsOfOrder) {
        SupplierDto supplierDto =  new SupplierDto(consumerName,detailsOfOrder);
        restTemplate.postForObject("http://CI00026731:9005/orders-1.0.0/supplier",supplierDto,String.class);
    }
}
