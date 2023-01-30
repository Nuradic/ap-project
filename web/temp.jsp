<% 
%>
    <html>

    <head>
        <title>Setting Cookies</title>
    </head>

    <body> 
        <center>
            <h1>Setting Cookies</h1>
        </center>
        <ul>
            <li>
                <p>
                    <b>First Name:</b>
                    <%= request.getParameter("fname")%>
                </p>
            </li>
            <li>
                <p>
                    <b>Last Name:</b>
                    <%= request.getParameter("lname")%>
                </p>
            </li>
        </ul>
        <center>
            <h1>Reading Cookies</h1>
         </center>
         <%
            Cookie cookie = null;
            Cookie[] cookies = null;
            
            // Get an array of Cookies associated with the this domain
            cookies = request.getCookies();
            
            if( cookies != null ) {
               out.println("<h2> Found Cookies Name and Value</h2>");
               
               for (int i = 0; i < cookies.length; i++) {
                  cookie = cookies[i];
                  out.print("Name : " + cookie.getName( ) + ",  ");
                  out.print("Value: " + cookie.getValue( )+" <br/>");
               }
            } else {
               out.println("<h2>No cookies founds</h2>");
            }
         %>
    </body>

    </html>