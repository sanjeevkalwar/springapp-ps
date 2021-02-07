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
"league_id",
"league_name",
"league_season",
"league_logo",
"country_logo"
})
public class League {

@JsonProperty("country_id")
private String countryId;
@JsonProperty("country_name")
private String countryName;
@JsonProperty("league_id")
private String leagueId;
@JsonProperty("league_name")
private String leagueName;
@JsonProperty("league_season")
private String leagueSeason;
@JsonProperty("league_logo")
private String leagueLogo;
@JsonProperty("country_logo")
private String countryLogo;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
* No args constructor for use in serialization
*
*/
public League() {
}

/**
*
* @param leagueName
* @param leagueLogo
* @param leagueSeason
* @param leagueId
* @param countryLogo
* @param countryName
* @param countryId
*/
public League(String countryId, String countryName, String leagueId, String leagueName, String leagueSeason, String leagueLogo, String countryLogo) {
super();
this.countryId = countryId;
this.countryName = countryName;
this.leagueId = leagueId;
this.leagueName = leagueName;
this.leagueSeason = leagueSeason;
this.leagueLogo = leagueLogo;
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

@JsonProperty("country_name")
public String getCountryName() {
return countryName;
}

@JsonProperty("country_name")
public void setCountryName(String countryName) {
this.countryName = countryName;
}

@JsonProperty("league_id")
public String getLeagueId() {
return leagueId;
}

@JsonProperty("league_id")
public void setLeagueId(String leagueId) {
this.leagueId = leagueId;
}

@JsonProperty("league_name")
public String getLeagueName() {
return leagueName;
}

@JsonProperty("league_name")
public void setLeagueName(String leagueName) {
this.leagueName = leagueName;
}

@JsonProperty("league_season")
public String getLeagueSeason() {
return leagueSeason;
}

@JsonProperty("league_season")
public void setLeagueSeason(String leagueSeason) {
this.leagueSeason = leagueSeason;
}

@JsonProperty("league_logo")
public String getLeagueLogo() {
return leagueLogo;
}

@JsonProperty("league_logo")
public void setLeagueLogo(String leagueLogo) {
this.leagueLogo = leagueLogo;
}

@JsonProperty("country_logo")
public String getCountryLogo() {
return countryLogo;
}

@JsonProperty("country_logo")
public void setCountryLogo(String countryLogo) {
this.countryLogo = countryLogo;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

@Override
public String toString() {
return new ToStringBuilder(this).append("countryId", countryId).append("countryName", countryName).append("leagueId", leagueId).append("leagueName", leagueName).append("leagueSeason", leagueSeason).append("leagueLogo", leagueLogo).append("countryLogo", countryLogo).append("additionalProperties", additionalProperties).toString();
}

@Override
public int hashCode() {
return new HashCodeBuilder().append(leagueName).append(leagueLogo).append(leagueSeason).append(leagueId).append(countryLogo).append(countryName).append(additionalProperties).append(countryId).toHashCode();
}

@Override
public boolean equals(Object other) {
if (other == this) {
return true;
}
if ((other instanceof League) == false) {
return false;
}
League rhs = ((League) other);
return new EqualsBuilder().append(leagueName, rhs.leagueName).append(leagueLogo, rhs.leagueLogo).append(leagueSeason, rhs.leagueSeason).append(leagueId, rhs.leagueId).append(countryLogo, rhs.countryLogo).append(countryName, rhs.countryName).append(additionalProperties, rhs.additionalProperties).append(countryId, rhs.countryId).isEquals();
}

}