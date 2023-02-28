package com.utils;

public class Components {
    public static String COURSE = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dashboard</title>
                <link rel="stylesheet" href="style.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

            </head>
            <body>
                <nav >
                    <h1>Logo</h1>
                    <ul>
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
                <br>
                <div class="dash-container">
                    <div class="sidebar">
                        <form action="POST">
                            <input type="text">
                            <button>Search</button>
                        </form>
                        <div class="course-card">
                            <button><h2>Course 1</h2></button>
                            <h2>&rarr;</h3>
                        </div>
                        <br>
                    </div>
                    <div class="main-container">
                       <div class="left">
                            <h1>description</h1>
                            <div>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit.Vel placeat, modi adipisci unde incidunt praesentium ducimus.</p>
                                <p>Lorem ipsum dolor sit, amet consectetur adipisicing elitafadf fdfd similique tenetur dignissimos earum eius possimus!</p>
                                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Dicta deleniti mollitia ipsa, iusto nemo officia temporibus!</p>
                            </div>

                                <h1>MATERIALS</h1>

                            <div class="">
                                <div class="materials">
                                    <div>
                                        <p>logic</p>
                                    </div>
                                    <div>
                                        <a href=""><button class="btn download"><i class="fa fa-download"></i> </button></i></a>
                                    </div>
                                </div>
                                <div class="materials">
                                    <div>
                                        <p>logic</p>
                                    </div>
                                    <div>
                                        <a href=""><button class="btn download"><i class="fa fa-download"></i> </button></i></a>
                                    </div>
                                </div>

                            </div>

                       </div>

                    </div>
                </div>
                <div>




            <!-- footer -->



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
                """;
    public static String HEADER = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
            <meta charset="UTF-8">
            <meta http-equiv="X-UA-Compatible" content="IE=edge">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Home</title>
            <link rel="stylesheet" href="css/home.css">
            <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
            integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />
            </head>
            <body>

            <nav class="navigation">
            <h1>AISS</h1>
            <ul class="home-navigation">
            <li class="nav-item">
            <a href="question">Ask</a>
            </li>
            nav-here
            <li class="nav-item">
            <a href="logout">LOG OUT</a>
            </li>
            </ul>

            </nav>

            <!-- home section -->

            <section class="home-section" id="home">
            <div class="background">
            <div class="home">
            <p class="para-home">Over Hundred courses to develope youself</p>
            <form action="" method="get">
            <div class="search">
            <input class="search-input" type="text" placeholder="search for your course"
            id="search" name="search" value="value-here">
            <label for="search">
            <button ><i class="fa-solid fa-magnifying-glass" for="search"></i></button>
            </label>
            </div>
            </form>
            </div>
            </div>

            </section>
            <h1><span> TOP</span> Categories</h1>
            <div class="card-container">
            """;

    public static String UPLOADCOURSE = """
            <!DOCTYPE html>
            <html>
              <head>
                <link rel="stylesheet" href="css/fileupload.css" />
              </head>
              <header>
                <nav>
                  <h1 class="main_text">AISS</h1>
                  <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">About</a></li>
                    <li><a href="#">Contact</a></li>
                  </ul>
                </nav>
              </header>
              <div class="home">
                <section>
                  <form action="course" method="post" enctype="multipart/form-data">
                    <h4>Add Material</h4>
                    <div>
                      <label for="course">Course Name:</label>
                      <input type="text" id="course" name="name"/>
                      <label for="material-description">Course Description:</label>
                      <textarea id="material-description" name="description"></textarea>

                      <label for="file-upload">Course Cover:</label>
                      <input type="file" id="file-upload" name="file"/>
                    </div>
                    <input type="submit"/>
                  </form>
                </section>
              </div>
            </html>

                    """;

    public static String COURSEVIEW = """
            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Dashboard</title>
                <link rel="stylesheet" href="css/coursestyle.css">
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

            </head>
            <body>
                <nav >
                    <h1>AISS</h1>
                    <ul>
                        <li><a href="home">Home</a></li>
                        <li><a href="upload">Upload</a></li>
                        <li><a href="question">Ask</a></li>
                    </ul>
                </nav>
                <br>
                <div class="dash-container">
                    <div class="sidebar">
                        <form action="course">
                            <input type="text" name="search">
                            <button>Search</button>
                        </form>
                        <div class="course-card">
                            <button><h2>course-here</h2></button>
                            <h2>&rarr;</h3>
                        </div>
                        <br>

                    </div>
                    <div class="main-container">
                       <div class="left">
                            <h1>Description</h1>
                            <div><p>description-here</p></div>
                                <h1>MATERIALS</h1>
                                <div class="" >
                                <ol>
                                material-here
                                </ol>
                                </div>
                            </div>
                       </div>
                    </div>
                </div>
                <div>
            <!-- footer -->
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
                """;

    public static String SOCIAL = """
            <!DOCTYPE html>
            <html>
            <head>
            <title>Social</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
            <link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
            <link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
            <link rel="stylesheet" href="css/admin.css">
            <link rel="icon" href="icon.jpg">
            <style>
            html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
            </style>
            </head>
            <body class="w3-theme-l5">
            <div class="w3-container w3-content" style="max-width:1400px;margin-top:0px">

              <div class="w3-row">

                <div class="admin">
                  <div class="admin-container">
                    <h4 class="w3-center">My Profile</h4>
                   <p class="w3-center"><img src="/img/admin.jpg" class="w3-circle" style="height:106px;width:106px" alt="Avatar"></p>
                   <hr>
                   <p class="admininfo"><i class="fa fa-pencil fa-fw w3-margin-right w3-text-theme"></i> user-here </p>
                   <p class="admininfo"><i class="fa fa-home fa-fw w3-margin-right w3-text-theme"></i> Adama, Ethiopia</p>
                   <p class="admininfo"><i class="fa fa-birthday-cake fa-fw w3-margin-right w3-text-theme"></i> April 1,2002 </p>
                  </div>
                </div>
                <br>
                <div class="middle">
                <form action="question" method="POST">

                  <div class="w3-row-padding">
                    <div class="w3-col m12">
                      <div class="w3-card w3-round w3-white">
                        <div class="w3-container w3-padding">
                          <textarea type="textarea" contenteditable="true" class="w3-border w3-padding" name="post"></textarea></br>
                          <button type="submit" class="w3-button w3-theme"><i class="fa fa-pencil"></i> &nbsp;Post</button>
                        </div>
                      </div>
                    </div>
                  </div>

                  </form>

                 cards-here

                </div>
              </div>
            </div>
            <br>
            <script>
            function myFunction(id) {
              var x = document.getElementById(id);
              if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
                x.previousElementSibling.className += " w3-theme-d1";
              } else {
                x.className = x.className.replace("w3-show", "");
                x.previousElementSibling.className =
                x.previousElementSibling.className.replace(" w3-theme-d1", "");
              }
            }

            // Used to toggle the menu on smaller screens when clicking on the menu button
            function openNav() {
              var x = document.getElementById("navDemo");
              if (x.className.indexOf("w3-show") == -1) {
                x.className += " w3-show";
              } else {
                x.className = x.className.replace(" w3-show", "");
              }
            }
            </script>
            </body>
            </html>

                                    """;

    public static String ADMIN = """

            <!DOCTYPE html>
            <html lang="en">
            <head>
                <meta charset="UTF-8">
                <meta http-equiv="X-UA-Compatible" content="IE=edge">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Admin Dashboard</title>

                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css">
                <link rel="stylesheet" href="css/admin_dashboard_style.css">

            </head>
            <body>
                <div id="mySidenav" class="sidenav">
                    <p class="logo"> <span>AISS</p>
                    <a href="#" class="icon-a"><i class="fa fa-dashboard icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Dashboard</a>
                    <a href="#" class="icon-a"><i class="fa fa fa-users icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Users</a>
                    <a href="#" class="icon-a"><i class="fa fa-list icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Material list</a>
                    <a href="#" class="icon-a"><i class="fa fa-list-alt icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Order list</a>
                    <a href="#" class="icon-a"><i class="fa fa-cog icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Setting</a>
                    <a href="#" class="icon-a"><i class="fa fa-power-off icons"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Log-Out</a>


                </div>
                <style>
                *{font-family: Georgia, serif;}
                </style>
               <div id="main">
                <div class="head">
                    <div class="col-div-6">
                        <span style="font-size: 30px; cursor: pointor;color: white;" class="nav"> &#9776; Dashboard</span>
                        <span style="font-size: 30px; cursor: pointor;color: white;" class="nav2"> &#9776; Dashboard</span>
                    </div>
                    <div class="col-div-6"></div>

                    <div class="profile">
                        <img src="img/admin.jpg" style="border-radius: 90px;" alt="admin" height="70px" width="80px">
                        <span style="color: white;">Admin</span>
                    </div>


                </div>
                <div class="clearfix"></div>

               <div class="col-div-3">
                <div class="box">
                    <p>
                              <br/>
                    <span>Users
                    </span></p>
                    <i class="fa fa-users box-icon"></i>
                </div>
               </div>


               <div class="col-div-3">
                <div class="box">
                    <p>
                             <br/>
                    <span>Orders
                    </span></p>
                    <i class="fa fa-shopping-bag box-icon"></i>
                    </div>
               </div>

               <div class="col-div-3">
                <div class="box">
                    <p>
                              <br/>
                    <span>Books In Store
                    </span></p>
                    <i class="fa fa-tasks box-icon"></i>
                </div>
               </div>



               <div class="clearfix"></div>
               <br/><br/>


            <div class="clearfix"></div>

            </div>

            <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
               <script>
                $(".nav").click(function(){
                $("#mySidenav").css('width','70px');
                      $("#main").css('margin-left','70px');
                      $(".logo").css('visibility', 'hidden');
                      $(".logo span").css('visibility','visible');
                      $(".logo span").css('margin-left','-10px');
                      $(".icons.a").css('visibility', 'hidden');
                      $(".icons").css('visibility', 'visible');
                      $(".icons").css('margin-left', '-8px');
                      $(".nav").css('display', 'none');
                      $(".nav2").css('display', 'block');
                });
                $(".nav2").click(function(){
                    $("#mySidenav").css('width' , '300px');
                          $("#main").css('margin-left', '300px');
                          $(".logo").css('visibility', 'visible');
                          $(".logo span").css('visibility', 'visible');
                          $(".icons.a").css('visibility', 'visible');
                          $(".icons").css('visibility', 'visible');
                          $(".nav").css('display', 'block');
                          $(".nav2").css('display', 'none');
                });

               </script>
            </body>
            </html>
                                                    """;

}
