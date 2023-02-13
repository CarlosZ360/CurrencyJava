package arquitectura.software.demo.bl;

import arquitectura.software.demo.dto.CurrencyDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.math.BigDecimal;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@Service
public class CurrencyBl {
    public CurrencyDto obtain(String from, String to, BigDecimal amount) throws IOException {
        System.out.println("Tercera centinela");
        if(amount.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("El monto debe ser mayor a 0");
        }
        System.out.println("Cuarta centinela");

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/fixer/convert?from=" + from + "&to=" + to + "&amount=" + amount)
                .addHeader("apikey", "hKOSY55V1VVqszEwTNp8RHfsBpmi9GZg")
                //.method("GET", null)
                .build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        System.out.println("Quinta centinela");


        ObjectMapper mapper = new ObjectMapper();
        System.out.println("Sexta centinela");
        CurrencyDto currencyDto= mapper.readValue(result, CurrencyDto.class);
        System.out.println("Septima centinela");

        return currencyDto;
    }

}
