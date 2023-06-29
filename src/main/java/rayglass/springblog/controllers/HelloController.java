package rayglass.springblog.controllers;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /*
    /hello -> Hello World!
    /hello?name=bob -> Hello bob!
    /hello/bob -> Hello bob!

    GET /ads -> list of ads
    GET /ads?param=val -> search for subset of ads using param
    GET /ads/1 -> show page for ad with id1
    GET /ads/create -> show page to add an ad
    GET /ads/1/edit -> show page to edit an ad with id 1
    POST /ads/create -> insert the new ad
    PUT /ads/1 -> update an existing ad with id 1
    DELETE /ads/1 -> delete existing ad with id 1

     */

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello() {
//        return "Hello World!";

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(@RequestParam String name) {
//        return "<h1> Hello " + name + "!</h1>";

//    @GetMapping("/hello")
//    @ResponseBody
//    public String sayHello(@RequestParam @Nullable String name) {
//        if(name == null) {
//            name = "world";
//        }
//        return "<h1> Hello " + name + "!</h1>";
//    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHelloName(@PathVariable String name) {
        if(name == null) {
            name = "world";
        }
        return "<h1> Hello " + name + "!</h1>";
    }

}
