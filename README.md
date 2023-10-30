# API Gateway using Spring Cloud Gateway
## **Introduction**

The API Gateway project is designed to provide a simple yet effective solution for routing to APIs and handling cross-cutting concerns such as security, monitoring/metrics, and resiliency.

An API Gateway serves as a single entry point for managing, aggregating, and routing API requests. It is a key component in efficiently handling API traffic, ensuring security, and optimizing performance.

## **Architecture**

![architecture](https://github.com/abhishekjain1416/api-gateway/assets/142833334/f8132eb2-9507-4f31-9a23-4c3f4a0ec3cc)


### Keycloak as an Authentication Server
Here, the use case is to request an access token from Keycloak so that it can invoke other services on behalf of the authenticated user.

#### Configurations
Create Realm with following configurations:

| S No | Key | Value |
| --- | --- | --- |
| 1 | Grant Type | Client Credentials |
| 2 | Client Type | OpenID Connect |
| 3 | Access Type | Confidential |
| 4 | Service Account Roles | Enabled for the client |

#### Start keycloak

From a terminal, enter the following command to start Keycloak:
~~~
docker run -p 8181:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.5 start-dev
~~~
This command starts Keycloak exposed on the local port 8181 and creates an initial admin user with the username admin and password admin.
