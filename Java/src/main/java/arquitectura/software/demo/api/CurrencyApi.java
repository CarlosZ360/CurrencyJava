package arquitectura.software.demo.api;

import arquitectura.software.demo.dto.CurrencyDto;
import arquitectura.software.demo.dto.ResponseServiceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import arquitectura.software.demo.bl.CurrencyBl;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController

@RequestMapping("api/v1/currency")
public class CurrencyApi {
    private CurrencyBl currencyBl;

    public CurrencyApi(CurrencyBl currencyBl) {
        this.currencyBl = currencyBl;
    }

    @GetMapping("/obtain")
    public ResponseEntity<ResponseServiceDto<CurrencyDto>> obtain(@RequestParam String from, @RequestParam String to, @RequestParam BigDecimal amount) throws Exception {
        System.out.println("Primera centinela");
        CurrencyDto currencyDto = currencyBl.obtain(from, to, amount);
        System.out.println("Segunda centinela");
        ResponseServiceDto<CurrencyDto> ResponseServiceDto = new ResponseServiceDto<CurrencyDto>(currencyDto, true, "Success");
        return ResponseEntity.ok(ResponseServiceDto);

    }
}
