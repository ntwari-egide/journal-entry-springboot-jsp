
## Journal entry publisher - spring boot + jsp

## [](#table-of-content)Table of content

1.  [About the project](#about)
    -   [Built With](#built-with)
2.  [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installation](#installation)
3.  [Contributing](#contributing)
4.  [License](#license)
5.  [Contact](#contact)
##  [](#about)About The Project

Content editor, written in Spring boot + Java server page (Jsp)

### []()Weleome page : http://localhost:8080/home

![enter image description here](https://res.cloudinary.com/dpqasrwfu/image/upload/v1655815770/dev1_byh8pz.png)

### []()Get by Id : http://localhost:8080/getEntriesByIdGT?id=1
![enter image description here](https://res.cloudinary.com/dpqasrwfu/image/upload/v1655815770/dev_2_ei236v.png)

### []()Get by Category name :http://localhost:8080/getEntriesByCategorySorted?category=category+1


![enter image description here](https://res.cloudinary.com/dpqasrwfu/image/upload/v1655815770/dev_3_lnb9mx.png)


### []()Logic is very simple
This is how we route to the page from controller

```java
@RequestMapping("/home")  
public String home(){  
    return "home";  
}
```

Handling the request from the user and returning the response

```java
@RequestMapping("/getEntry")  
public ModelAndView getJournalEntry(@RequestParam int id) {  
  
    ModelAndView modelAndView = new ModelAndView();  
  JournalEntry entryFound = repository.findById(id).orElse(new JournalEntry());  
  
  modelAndView.addObject("entry", entryFound);  
  modelAndView.setViewName("getEntry");  
  
 return modelAndView;  
  
}
```
Wanna, know how to handle complex queries, like getting entries by category name ?

```java
@RequestMapping("/getEntriesByCategory")  
public ModelAndView getEntriesByCategory ( @RequestParam String  category) {  
  
    ModelAndView modelAndView = new ModelAndView();  
  
  List<JournalEntry> entries = repository.findByCategory(category);  
  
  modelAndView.addObject("entries", entries);  
  
  modelAndView.setViewName("getEntriesByCategory");  
  
 return modelAndView;  
}
```

so how do we call above actions inside our servlet jsp pages (home.jsp)

```html
<form action="addEntry">  
   <div>Add New Journal Entry :</div><br>  
   <div>Id :</div> <input type="text" name="id"><br>  
   <div>Title :</div> <input type="text" name="title"><br>  
   <div>Category :</div> <input type="text" name="category"><br>  
  
   <input type="submit">  
</form><br><br><br>  
  
<form action="getEntry">  
   <div>Enter the Id to get Specific Entry:</div><br>  
   <input type="text" name="id"><br>  
  
   <input type="submit">  
</form><br><br><br>
```

And also rendering list of objects from the server is very simple

```html
<c:forEach items="${entries}" var="entry">  
   <div class="entry-container">  
           <p>ID: <t> ${entry.id}</p>  
           <p>Content: <t> ${entry.title}</p>  
           <p>Category: <t> ${entry.category}</p>  
   </div>  <br />  
</c:forEach>
```

### NOTE: To enable your foreach you need to import this library
```java
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```
how do we add google fonts, and other styles ?
-> it is very simple.
how ?
-> do you know html, right ? , so there is no big difference

```html
<style>  
    body {  
        background-color: #C4E5FF;  
        padding: 2em;  
        font-family: 'Poppins', sans-serif;  
    }  
</style>  
<title>Get entries by category</title>  
<link href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,500;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
```


###  [](#installation)Installation
After cloning, run 
-   `mvn clean install`
### [](#installation)Run
-  	`mvn spring-boot:run` 
- open the link in the browser : [http://localhost:8080/home](http://localhost:8080/home)

## [](#contributing)Contributing

Contributions are what make the this Journal dev project such an amazing, fantastic, inspiring, and creative ideas. Any contributions you make are **greatly appreciated**.

1.  Fork the Project from our github [Link](https://github.com/ntwari-egide/Genv-backend-nestjs)
2.  Create your Feature Branch (`git checkout -b ft-AmazingFeature-userstories_id`)
3.  Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4.  Push to the Branch (`git push origin ft-AmazingFeature-userstories_id`)
5.  Open a Pull Request
6.  Add yourself as assignee
7.  Add [ntwariegide2@gmail.com](mailto:ntwariegide2@gmail.com) as reviewer

## [](#license) License

Distributed under the MIT License. See `LICENSE` for more information.

## [](#contact)Contact

Egide Ntwari - [ntwali_egides](https://twitter.com/ntwali_egides) - [ntwariegide2@gmail.com](mailto:ntwariegide2@gmail.com)

PROJECT LINK: [https://github.com/ntwari-egide/journal-entry-springboot-jsp](https://github.com/ntwari-egide/journal-entry-springboot-jsp)
