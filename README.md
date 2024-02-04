# qa-assessment

Requirement :
The project requires Java 17

The project makes use of Gradle and uses
the [Gradle wrapper](https://docs.gradle.org/current/userguide/gradle_wrapper.html), which means you don't need Gradle
installed.

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


