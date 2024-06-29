# HM Outfit Recommendation System

## Overview
This project is a backend service for recommending outfits based on user inputs like event type, budget, and preferences.

## Architecture (Architecture diagram attached in the repository)
- **Customer Interaction**
- **Inventory Management**
- **Recommendation Module**
- **Shopping Cart Module**
- **Analytics Module**
  
## ERD (ERD diagram attached in the repository)
- **Customer**
- **Event**
- **Feedback**
- **Inventory**
- **Recommendation**
- **Preferences**
- **ProductCategory**

## Endpoints
- `POST /recommendations`: Accepts user inputs and returns outfit recommendations.

## Sample Request
```json
1. Successful Recommendation
Request
Method: POST
URL: http://localhost:8080/recommendation
Body:
{
  "customerId": 1,
  "eventType": "Christmas",
  "brand": "H&M",
  "budget": 3000.0
}
Expected Response
Status: 200 OK
Response :
{
    "recId": 1,
    "customer": {
        "customerId": 1,
        "name": "John Doe",
        "age": 30,
        "gender": "Male",
        "address": "123 Main Malmo",
        "email": "john.doe@example.com",
        "feedbacks": [],
        "recommendations": [],
        "preferences": []
    },
    "eventName": "Christmas",
    "items": [
        {
            "itemId": 2,
            "name": "Dress Shirt",
            "category": "Shirts",
            "price": 500.0,
            "brand": "H&M",
            "colour": "White",
            "stock": 15
        },
        {
            "itemId": 1,
            "name": "Tuxedo",
            "category": "Suits",
            "price": 2500.0,
            "brand": "H&M",
            "colour": "Black",
            "stock": 10
        }
    ]
}

2. Customer Not Found
Request
Method: POST
URL: http://localhost:8080/recommendation
Body:
{
  "customerId": 999,
  "eventType": "Christmas",
  "brand": "H&M",
  "budget": 3000.0
}
Expected Response
Status: 404 Not Found
Response:
{
    "error": "Customer not found"
}

3. Event Not Found
Request
Method: POST
URL: http://localhost:8080/recommendation
Body :
{
  "customerId": 1,
  "eventType": "Jump",
  "brand": "H&M",
  "budget": 3000.0
}

Expected Response
Status: 404 Not Found
Response:
{
    "error": "Event not found"
}

4. Brand Not Available
Request
Method: POST
URL: http://localhost:8080/recommendation
Body:
{
  "customerId": 2,
  "eventType": "Jump",
  "brand": "Gucci",
  "budget": 3000.0
}

Expected Response
Status: 404 Not Found
Response:
{
    "error": "Brand not found"
}

5. Exceeding Budget
Request
Method: POST
URL: http://localhost:8080/recommendation
Body:
{
  "customerId": 1,
  "eventType": "Christmas",
  "brand": "H&M",
  "budget": 1000.0
}

Expected Response
Status: 404 Not Found
Response:
{
    "error": "Cannot find the suitable items for category: Suits within budget."
}
