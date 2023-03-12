## Rest Server

### API Documentation
- ### Save Student Details 📃
  > POST /saveStudent
  #### Response 200 🟢
  ```
    [
      {
      "id": long,
      "name": string,
      "age": integer,
      "branch": string,
      "sex": string,
      "percentage": double
      }
  ]
  ```
  Example 
  - > POST /saveStudent
    ``` 
     request.body = 
      [
    {
    "name":"a",
    "age":"24",
    "branch":"cse",
    "sex":"male",
    "percentage":"97"

    },
    {
    "name":"b",
    "age":"24",
    "branch":"cse",
    "sex":"female",
    "percentage":"34"
    }]
    ```
    **Response 200**
      ```
      [
      {
      "id": 1,
      "name": "a",
      "age": 24,
      "branch": "cse",
      "sex": "male",
      "percentage": 97.0
      },
      {
      "id": 2,
      "name": "b",
      "age": 24,
      "branch": "cse",
      "sex": "female",
      "percentage": 34.0
      }
    ]
      ```
      **NOTE:** id is auto generated <br>
- ### Get all student Details 👾
  > GET getALLStudent
  #### Response 200  🟢
  ```
     [
      {
      "id": long,
      "name": string,
      "age": integer,
      "branch": string,
      "sex": string,
      "percentage": double
      }
  ]
  ```
  Example
  - > GET /getAllStudent
    ``` 
     request.body = {}
    ```
    **Response 200**
      ```
      [
      {
      "id": 1,
      "name": "a",
      "age": 24,
      "branch": "cse",
      "sex": "male",
      "percentage": 97.0
      },
      {
      "id": 2,
      "name": "b",
      "age": 24,
      "branch": "cse",
      "sex": "female",
      "percentage": 34.0
      }
    ]
      ```

- ### BranchWiseStudent 👾
  > POST /branchWiseStudent?branch=
  #### Response 200  🟢
  ```
   [
      {
      "id": long,
      "name": string,
      "age": integer,
      "branch": string,
      "sex": string,
      "percentage": double
      }
  ]
  ```
  Example
  - > POST /branchWiseStudent?branch=cse
    ``` 
     
    ```
    **Response 200**
      ```
     [
    {
        "id": 1,
        "name": "a",
        "age": 24,
        "branch": "cse",
        "sex": "male",
        "percentage": 97.0
    },
    {
        "id": 2,
        "name": "b",
        "age": 24,
        "branch": "cse",
        "sex": "female",
        "percentage": 34.0
    }
    ]
      ```


**NOTE:** Branch name to be given in parameter

- ### Top3StudentBranchWise 👾
  > GET /top3StudentBranchWise
  #### Response 200  🟢
  ```
    [
      {
      "id": long,
      "name": string,
      "age": integer,
      "branch": string,
      "sex": string,
      "percentage": double
      }
  ]
  ```
  Example
  - > GET /top3StudentBranchWise
    ``` 
    request.body = {}
    ```
    **Response 200**
      ```
      [
    {
        "id": 1,
        "name": "a",
        "age": 24,
        "branch": "cse",
        "sex": "male",
        "percentage": 97.0
    },
    {
        "id": 9,
        "name": "i",
        "age": 24,
        "branch": "cse",
        "sex": "male",
        "percentage": 90.0
    },
    {
        "id": 6,
        "name": "f",
        "age": 24,
        "branch": "cse",
        "sex": "male",
        "percentage": 87.0
    },
    {
        "id": 7,
        "name": "g",
        "age": 24,
        "branch": "ece",
        "sex": "male",
        "percentage": 98.0
    }
]
      ```


- ### SexWiseToppers 👾
  > GET /sexWiseToppers
  #### Response 200  🟢
  ```
  [
      {
      "id": long,
      "name": string,
      "age": integer,
      "branch": string,
      "sex": string,
      "percentage": double
      }
  ]
  ```
  Example
  - > GET /sexWiseToppers
    ``` 
     request.body = {}
    ```
    **Response 200**
      ```
     [
    {
        "id": 2,
        "name": "b",
        "age": 24,
        "branch": "cse",
        "sex": "female",
        "percentage": 34.0
    },
    {
        "id": 1,
        "name": "a",
        "age": 24,
        "branch": "cse",
        "sex": "male",
        "percentage": 97.0
    },
    {
        "id": 7,
        "name": "g",
        "age": 24,
        "branch": "ece",
        "sex": "male",
        "percentage": 98.0
    }
]
      