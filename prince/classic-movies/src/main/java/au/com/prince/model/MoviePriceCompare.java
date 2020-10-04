package au.com.prince.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

/**
 * Movie Price Compare Fields Definition
 */
@Component
public class MoviePriceCompare {
    @JsonProperty("Poster")
    private String poster;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("ProviderLow")
    private String providerLow;
    @JsonProperty("ProviderHigh")
    private String providerHigh;
    @JsonProperty("PriceLow")
    private double priceLow;
    @JsonProperty("PriceHigh")
    private double priceHigh;

    public MoviePriceCompare() { }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProviderLow() {
        return providerLow;
    }

    public void setProviderLow(String providerLow) {
        this.providerLow = providerLow;
    }

    public String getProviderHigh() {
        return providerHigh;
    }

    public void setProviderHigh(String providerHigh) {
        this.providerHigh = providerHigh;
    }

    public double getPriceLow() {
        return priceLow;
    }

    public void setPriceLow(double priceLow) {
        this.priceLow = priceLow;
    }

    public double getPriceHigh() {
        return priceHigh;
    }

    public void setPriceHigh(double priceHigh) {
        this.priceHigh = priceHigh;
    }

    @Override
    public String toString() {
        return "MoviePriceCompare{" +
                "poster='" + poster + '\'' +
                ", title='" + title + '\'' +
                ", providerLow='" + providerLow + '\'' +
                ", providerHigh='" + providerHigh + '\'' +
                ", priceLow=" + priceLow +
                ", priceHigh=" + priceHigh +
                '}';
    }
}
