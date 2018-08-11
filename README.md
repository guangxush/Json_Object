# json
Test JSON data transfer to JAVA Object using Spring Boot

## How to using postman to test json data
1. Using the postman menu on the left to "Add Request"
2. Select "POST" and Params is "http://localhost:8080/vehicle/car"
3. Headers add this: "KEY": Content-Type ; "VALUE": application/json
4. Body select the raw and add this:
    ```json
    {
        "color": "Blue",
        "miles": 300,
        "vin": "1234"
    }
    ```
5. click the "Send" Button
6. Get the response as this:
   ```json
    {
        "color": "Blue",
        "miles": 400,
        "vin": "1234"
    }
   ```