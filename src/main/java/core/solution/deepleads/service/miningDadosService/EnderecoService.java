package core.solution.deepleads.service.miningDadosService;//package mineracao.dados.solution.service;
//
//import lombok.RequiredArgsConstructor;
//import mineracao.dados.solution.Feign.EnderecoFeign;
//import mineracao.dados.solution.models.EnderecoRequestModel;
//import mineracao.dados.solution.models.EnderecoResponseModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//
//
//@RequiredArgsConstructor
//@Service
//public class EnderecoService {
//
//    @Autowired
//    private final EnderecoFeign enderecoFeign;
//
//    public EnderecoResponseModel executa(EnderecoRequestModel request) {
//        return enderecoFeign.buscaEnderecoCep(request.getCep());
//    }
//}
