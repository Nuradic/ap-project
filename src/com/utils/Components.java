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
            <p class="para-home">Over Hundred courses to develope youself</p>
            <div class="search">
            <input class="search-input" type="text" placeholder="search for your course"
            id="search" >
            <label for="search">
            <i class="fa-solid fa-magnifying-glass" for="search"></i>
            </label>
            </div>
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
                        <li><a href="#">Home</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                </nav>
                <br>
                <div class="dash-container">
                    <div class="sidebar">
                        <form action="/">
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
                                material-here
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

}
