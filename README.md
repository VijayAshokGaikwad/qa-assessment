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
    "price": 10.00
  },
  {
    "name": "item2",
    "price": 20.00
  }
]
```
