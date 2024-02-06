# qa-assessment

Requirement :
The project requires Java 17

The project makes use of Gradle and uses
the [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html), which means you don't need Gradle
installed.

This project works with Postgres database. To run locally, database named 'postgres' need to be created in local postgres. 


### Assignment Tasks Done / Not done  
#### Add new grocery items to the system                           -- Done
#### View existing grocery items                                   -- Done
#### Remove grocery items from the system                          -- Done
#### Update details (e.g., name, price) of existing grocery items  -- Done
#### Manage inventory levels of grocery items                      -- Done
#### View the list of available grocery items                      -- Done
#### Ability to book multiple grocery items in a single order      -- Done
#### Role based APIs for USER and Admin                            -- NOT Done

### Advanced Challenge:
#### Containerize the application using Docker for ease of deployment and scaling.     -- Done
#### Use any relational database of your choice.                                       -- Done




## Endpoints supported

### Get Grocery items

Endpoint

```text
GET /api/v1/grocery-items
```

Example output

```json
[
  {
    "name": "item1",
    "price": 10.00,
    "availableQuantity": 10
  },
  {
    "name": "item2",
    "price": 20.00,
    "availableQuantity": 0
  }
]
```

### Get Available Grocery items

Endpoint

```text
GET /api/v1/available/grocery-items
```

Example output

```json
[
  {
    "name": "item1",
    "price": 10.00,
    "availableQuantity": 10
  }
]
```

### Add new multiple Grocery items in the inventory

```text
POST /api/v1/grocery-items
```

```json
[
  {
    "name": "abc",
    "price": 10.00,
    "availableQuantity": 10
  },
  {
    "name": "def",
    "price": 20.00,
    "availableQuantity": 20
  }
]
```

### Update existing Grocery item in the inventory

Endpoint

```text
PUT api/v1/grocery-items
```

Request Body :

```json
{
  "id": 2,
  "name": "xyz",
  "price": 35.00,
  "availableQuantity": 2
}

```

### Remove a grocery item in the inventory

```text
DELETE /api/v1/grocery-items/1
```

## Order Management

### Add new order with multiple items 

```text
POST /api/v1/orders
```

```json
[
  {
    "groceryId": 1,
    "quantity": 1
  },
  {
    "groceryId": 2,
    "quantity": 5
  }
]
```

### Get all orders list
```text
GET /api/v1/orders
```

###

