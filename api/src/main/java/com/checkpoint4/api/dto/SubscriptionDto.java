package com.checkpoint4.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SubscriptionDto {

    private String serviceName;
    private Date subscriptionDate;
    private Date expirationDate;
    private float price;
    private String url;
    private String categorie;
    private String type;

}
