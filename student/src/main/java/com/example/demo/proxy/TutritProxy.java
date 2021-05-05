package com.example.demo.proxy;

import com.example.demo.model.TutritHomeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "tutrit.api", url = "https://api.tutrit.com")
public interface TutritProxy {

    @GetMapping("/home")
    TutritHomeDto getHome();
}
