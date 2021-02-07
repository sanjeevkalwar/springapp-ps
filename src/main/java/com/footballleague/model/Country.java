
package com.footballleague.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "country_id",
    "country_name",
    "country_logo"
})
public class Country {

    @JsonProperty("country_id")
    private String countryId;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("country_logo")
    private String countryLogo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Country() {
    }

    /**
     * 
     * @param countryLogo
     * @param countryName
     * @param countryId
     */
    public Country(String countryId, String countryName, String countryLogo) {
        super();
        this.countryId = countryId;
        this.countryName = countryName;
        this.countryLogo = countryLogo;
    }

    @JsonProperty("country_id")
    public String getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public Country withCountryId(String countryId) {
        this.countryId = countryId;
        return this;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Country withCountryName(String countryName) {
        this.countryName = countryName;
        return this;
    }

    @JsonProperty("country_logo")
    public String getCountryLogo() {
        return countryLogo;
    }

    @JsonProperty("country_logo")
    public void setCountryLogo(String countryLogo) {
        this.countryLogo = countryLogo;
    }

    public Country withCountryLogo(String countryLogo) {
        this.countryLogo = countryLogo;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Country withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("countryId", countryId).append("countryName", countryName).append("countryLogo", countryLogo).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(countryLogo).append(countryName).append(additionalProperties).append(countryId).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Country) == false) {
            return false;
        }
        Country rhs = ((Country) other);
        return new EqualsBuilder().append(countryLogo, rhs.countryLogo).append(countryName, rhs.countryName).append(additionalProperties, rhs.additionalProperties).append(countryId, rhs.countryId).isEquals();
    }

}
