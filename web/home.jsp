<%-- <%@ page import="java.util.*,com.models.*,com.jdbc.*"%>
<%!ArrayList<Course>courses=Database.getCourses();%> --%>
<%-- <%! ArrayList courses= request.getAttribute("courses")%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home Page</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
</head>
<body>

    <nav class="navigation">
        <h1>AISS</h1>
        <ul class="home-navigation">
            <li class="nav-item">
                <a href="#HOME">HOME</a>
            </li>
            <li class="nav-item">
                <a href="#Messages">Messages</a>
            </li>
            <li class="nav-item">
                <a href="#CONTACT">Ask</a>
            </li>
            <li class="nav-item">
                <a href="#HELP">Support</a>
            </li>
        </ul>

    </nav>



<!-- home section -->

    <section class="home-section" id="home">
        <div class="background">
           <div class="home">           
            <p class="para-home">Lorem, ipsum dolor sit amet consectetur adipisicing elit. Delectus omnis soluta odit et id doloribus!</p>
                <div class="search">
                    <input class="search-input" type="text" placeholder="search for your course" id="search" >
                    <label for="search">
                        <i class="fa-solid fa-magnifying-glass" for="search"></i>
                    </label>
                </div>
            </div> 
        </div>
        
        
    </section>
   





<!-- main sectiokn -->

    <section class="main-section">

        <div class="more-tranding">
            <div class="for online-students">
                <i class="fa-solid fa-laptop"></i>
                <div class="">
                    <span>3k</span>
                    <p>online students </p> 
                </div>
            </div>
           
            <div class="for expert-tutors">                
                <i class="fa-solid fa-user-tie"></i>
                <div class="">
                    <span>3k</span>
                    <p>expert tutors dy</p> 
                </div>
            </div>

            <div class="for tranding">
                <i class="fa-solid fa-graduation-cap"></i>
                <div class="">
                    <span>3k</span>
                    <p>trending daily</p>
                </div>
            </div>

            <div class="for certificates-deliverd">
                <i class="fa-solid fa-certificate"></i>
                <div class="">
                    <span>3k</span>
                    <p>certificates</p> 
                </div>
            </div>

        </div> 

        <h1><span> TOP</span> Categories</h1>

        <div class="card-container">
        <%
        for(int i=0;i<10;i++){
            %>
            <div class="inner-card">
                <img src="./image/dies.jpg" alt="dies picture" width="300">
                <h2>Hello</h2>
                <p>World!</p>
                <button>Add Course</button>
            </div>
            <%
        }

        %>
        </div>     

    
    </section>

    

<!-- footer section -->

     <footer>
        <div class="footer-part">
            
            <div class="footer about-us">
                <p class="para-list">About Us</p>
                <ul class="list-in-footer">
                    <li>company</li>
                    <li>Our Team</li>
                    <li>Careers</li>
                    <li>Helping</li>
                    
                </ul>
            </div>

            <div class="footer careers">
                <p class="para-list">careers</p>
                <ul class="list-in-footer">
                    <li></li>
                    <li></li>
                    <li></li>
                    <li></li>
                    
                    <li></li>
                </ul>

            </div>
            <div class="footer contact-us">
                <p class="para-list">contact us</p>
                <div class="icon-for-social">
                    <i class="fa-brands fa-facebook"><a href=""></a></i>
                    <i class="fa-brands fa-instagram"><a href=""></a></i>
                    <i class="fa-brands fa-twitter"><a href=""></a></i>
                    <i class="fa-brands fa-telegram"><a href=""></a></i>
                    <i class="fa-brands fa-linkedin"><a href=""></a></i>

                </div>
            </div> 

             
            
            </div>
            
            <hr>

            <div class="last-div">
                <p class="ending-para">AISS is optimized for learning, testing,<br> and  training. </br> </p>
                <p class="copyright">Copyright &copy; 2015 AISS.com</p>
            </div>


    </footer> 


</body>
</html>