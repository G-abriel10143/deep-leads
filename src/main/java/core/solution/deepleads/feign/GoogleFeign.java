package core.solution.deepleads.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url = "https://maps.googleapis.com/maps/api", name = "googleMaps")
public interface GoogleFeign {

     static String API_KEY = "AIzaSyDAkXd3lIMPrXI2Yrmx5HHlZLzWSAe2z0k";

     @GetMapping("/geocode/json")
    String getAdressData(@RequestParam String address, @RequestParam String key );
}
