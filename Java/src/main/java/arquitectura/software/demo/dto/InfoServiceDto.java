package arquitectura.software.demo.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class InfoServiceDto {
    private BigInteger timestamp;
    private BigDecimal rate;
    public InfoServiceDto() {
    }
    public InfoServiceDto(BigInteger timestamp, BigDecimal rate) {
        this.timestamp = timestamp;
        this.rate = rate;
    }

    public BigInteger getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(BigInteger timestamp) {
        this.timestamp = timestamp;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "InfoServiceDto{" +
                "timestamp=" + timestamp +
                ", rate=" + rate +
                '}';
    }
}
