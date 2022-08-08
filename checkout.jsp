<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%--<jsp:useBean id="cart" scope="request" type="vn.edu.hcmuaf.fit.demo.beans.Cart"/>;--%>

<!DOCTYPE html>
<!--
ustora by freshdesignweb.com
Twitter: https://twitter.com/freshdesignweb
URL: https://www.freshdesignweb.com/ustora/
-->
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Techonology Store</title>

    <link href='http://code.TechonologyStore.com/css?family=Titillium+Web:400,200,300,700,600' rel='stylesheet'
          type='text/css'>
    <link href='http://code.TechonologyStore.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet'
          type='text/css'>
    <link href='http://code.TechonologyStore.com/css?family=Raleway:400,100' rel='stylesheet' type='text/css'>

    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css">

    <!-- Font Awesome -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="css/owl.carousel.css">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="contact.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="header-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="user-menu">

                    <ul>
                        <c:if test="${sessionScope.auth  != null}">
                            <li><a href="">Hello ${sessionScope.auth.username}</a></li>
                            <li><a href="/demo/LogOut">Logout</a></li>
                        </c:if>
                        <c:if test="${sessionScope.auth  == null}">
                            <li><a href="/demo/Login"><i class="fa fa-user"></i> Login </a></li>
                            <li> |</li>
                            <li><a href="/demo/Register"><i class="fa fa-user"></i> Register </a></li>
                        </c:if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End header area -->

<div class="site-branding-area">
    <div class="container">
        <div class="row">
            <div class="col-sm-6">
                <div class="logo">
                    <h1><a href="./"><img src="img/logo.png"></a></h1>
                </div>
            </div>
            <div class="col-sm-6">
                <div class="shopping-item">
                    <a href="/demo/Cart">Cart - <span class="cart-amunt"></span> <i class="fa fa-shopping-cart"></i>
                        <span class="product-count">${cart.totalOrder}</span></a>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End site branding area -->
<div class="mainmenu-area">
    <div class="container">
        <div class="row">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/demo/home">Home</a></li>
                    <li><a href="/demo/shop">Shop page</a></li>
                    <li><a href="/demo/Cart">Cart</a></li>
                    <li class="active"><a href="/demo/Contact">Contact</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Contact</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="container-contact100">
    <div class="wrap-contact100">
        <div class="contact100-form-title">
<span class="contact100-form-title-1">
Contact Us
</span>
            <span class="contact100-form-title-2">
Feel free to drop us a line below!
</span>
        </div>
        <form class="contact100-form validate-form">
            <div class="wrap-input100 validate-input" data-validate="Name is required">
                <span class="label-input100">Full Name:</span>
                <input class="input100" type="text" name="name" placeholder="Enter full name">
                <span class="focus-input100"></span>
            </div>
            <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
                <span class="label-input100">Email:</span>
                <input class="input100" type="text" name="email" placeholder="Enter email addess">
                <span class="focus-input100"></span>
            </div>
            <div class="wrap-input100 validate-input" data-validate="Phone is required">
                <span class="label-input100">Phone:</span>
                <input class="input100" type="text" name="phone" placeholder="Enter phone number">
                <span class="focus-input100"></span>
            </div>
            <div class="wrap-input100 validate-input" data-validate="Message is required">
                <span class="label-input100">Message:</span>
                <textarea class="input100" name="message" placeholder="Your Comment..."></textarea>
                <span class="focus-input100"></span>
            </div>
            <div class="container-contact100-form-btn">
                <button class="contact100-form-btn">
<span>
Submit
<i class="fa fa-long-arrow-right m-l-7" aria-hidden="true"></i>
</span>
                </button>
            </div>
        </form>
    </div>
</div>

<div class="footer-top-area">
    <div class="zigzag-bottom"></div>
    <div class="container">
        <div class="row">
            <div class="col-md-3 col-sm-6">
                <div class="footer-about-us">
                    <h2>Technology<span> Store</span></h2>
                    <p>Follow us across platforms</p>
                    <div class="footer-social">
                        <a href="#" target="_blank"><i class="fa fa-facebook"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-twitter"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-youtube"></i></a>
                        <a href="#" target="_blank"><i class="fa fa-linkedin"></i></a>
                    </div>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">User Navigation </h2>
                    <ul>
                        <li><a href="#">My account</a></li>
                        <li><a href="#">Order history</a></li>
                        <li><a href="#">Wishlist</a></li>
                        <li><a href="#">Vendor contact</a></li>
                        <li><a href="#">Front page</a></li>
                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-menu">
                    <h2 class="footer-wid-title">Categories</h2>
                    <ul>
                        <li><a href="#">Laptop</a></li>
                        <li><a href="#">Gaming PC</a></li>
                        <li><a href="#">Computer Screen</a></li>

                    </ul>
                </div>
            </div>

            <div class="col-md-3 col-sm-6">
                <div class="footer-newsletter">
                    <h2 class="footer-wid-title">Newsletter</h2>
                    <p>Sign up to our newsletter and get exclusive deals you wont find anywhere else straight to your
                        inbox!</p>
                    <div class="newsletter-form">
                        <form action="#">
                            <input type="email" placeholder="Type your email">
                            <input type="submit" value="Subscribe">
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div> <!-- End footer top area -->

<div class="footer-bottom-area">
    <div class="container">
        <div class="row">
            <div class="col-md-8">

            </div>

            <div class="col-md-4">
                <div class="footer-card-icon">
                    <i class="fa fa-cc-discover"></i>
                    <i class="fa fa-cc-mastercard"></i>
                    <i class="fa fa-cc-paypal"></i>
                    <i class="fa fa-cc-visa"></i>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Latest jQuery form server -->
<script src="https://code.jquery.com/jquery.min.js"></script>

<!-- Bootstrap JS form CDN -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>

<!-- jQuery sticky menu -->
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.sticky.js"></script>

<!-- jQuery easing -->
<script src="js/jquery.easing.1.3.min.js"></script>

<!-- Main Script -->
<script src="js/main.js"></script>

<script type="text/javascript" src="vendor/js/jquery.min.js"></script>
<script type="text/javascript" src="vendor/js/popper.min.js"></script>
<script type="text/javascript" src="vendor/js/bootstrap.min.js"></script>
<script type="text/javascript" src="vendor/js/mdb.min.js"></script>
</body>
</html>