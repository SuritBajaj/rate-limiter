# Rate-Limiter
<h2>Project UseCase:</h2>
Rate Limiter App exposes an API that can be called X no of times in a given time period. Rate Limiting Means ability to make sure your API can be used only for X number of times in a particular time period.      As an API provider we have decided to rate limit the callers with X Number calls per Hour per each tenant. If the caller has reached the Limit, we have to return an error code stating same for remaining time of that hour.Once the block period is completed user should be able to access the API         

Note : For simplicity let’s assume there is only one API exposed to the tenant and rate Limit is calculated at each clock hour          

Tenant : This is a third party company registered for the API calls.

<h2>Steps to run the application:</h2>
1. Run the driver class RateLimiterLauncher.java to load the application. <br />
2. Use POSTMAN or web browser to make an API call. <br />
<br />
<br />
<b>API Syntax:</b><br />
http://localhost:8080/tenant/10<br />
Here 10 is the tennatId.<br />
<br />
In <b>Application.properties</b> file both the threshold and the duration can be configured. <br/>
<br />
Eg: By default we have configured  <br />
<b>app_properties_threshold</b> = 100  <br />
<b>app_properties_duration</b> = 30000 ms (1hr) <br />

So as per default implementation 100 request are allowed in 1hr. If it makes more than 100 requests then Error Code 429 is sent for TOO MANY REQUESTS. It it makes within 100 requests then STATUS=OK is sent. Once it completes one hour then it can again make 100 requests in the next hour.  <br />

<h2>Sample Testcase:</h2>  <br />
Executed with the following configuration: <br />
<b>app_properties_threshold</b>=3<br />
<b>app_properties_duration</b>=30000 (30s)<br />
<br />
<br />
<b>Request:</b><br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
GET http://localhost:8080/tenant/100 <br />
<br />
<b>Response:</b><br />
Request allowed for the tenant:100 <br />
Request allowed for the tenant:100 <br />
Request allowed for the tenant:100 <br />
Too many requests for the Tenant:100 Retry after:27(s) <br />
Too many requests for the Tenant:100 Retry after:18(s) <br />
Too many requests for the Tenant:100 Retry after:11(s) <br />
Request allowed for the tenant:100 <br />

<h2>Snapshots:</h2>

![snap1](https://user-images.githubusercontent.com/28047472/128707476-00794b9c-48bc-4fe7-b005-709de832e8f5.png)
![image](https://user-images.githubusercontent.com/28047472/128707515-76630dfc-84e8-41b8-8dbf-19fabfb972fd.png)

