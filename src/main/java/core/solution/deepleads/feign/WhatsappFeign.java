//package core.solution.deepleads.feign;
//
//import core.solution.deepleads.dataTransferObject.WhatsappDto;
//import core.solution.deepleads.response.WhatsappResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//@FeignClient(url = "https://app.whatsgw.com.br/api/WhatsGw/Send", name = "whatsapp feign")
//public interface WhatsappFeign {
//
//    @PostMapping()
//    @Autowired
//    WhatsappResponse SendMessageWhatsapp(@RequestBody WhatsappDto whatsappDto);
//
//
//}
