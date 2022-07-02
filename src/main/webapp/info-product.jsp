<%@ page import="com.google.gson.Gson" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="cart" scope="request" type="vn.edu.hcmuaf.fit.demo.beans.Cart"/>
<!DOCTYPE html>
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
                        <li><a href="/demo/Login"><i class="fa fa-user"></i> Login </a></li>
                        <li> |</li>
                        <li><a href="/demo/Register"><i class="fa fa-user"></i> Register </a></li>
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
                    <li class="active"><a href="/demo/Cart">Cart</a></li>
                    <li><a href="/demo/CheckOut">Checkout</a></li>
                </ul>
            </div>
        </div>
    </div>
</div> <!-- End mainmenu area -->

<div class="product-big-title-area">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="product-bit-title text-center">
                    <h2>Product information</h2>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="info-product">
    <c:set var="prducts" value="${cart.productList}"/>
    <c:forEach items="${prducts}" var="product">
    <div class="info-img">
        <img src="${product.img}" alt="">
    </div>
    <div id="order_review" style="position: relative;">
        <table class="shop_table">
            <thead>
            <tr>
                <th class="product-name">Information</th>
                <th class="product-total"></th>
            </tr>
            </thead>
            <tbody>
            <tr class="cart_item">
                <td class="product-name">Name
                    <strong class="product-quantity"></strong>
                </td>
                <td class="product-total">
                    <span class="name">${product.name}</span>
                </td>
            </tr>
            </tbody>
            <tfoot>
            <tr class="cart-price">
                <th>Price</th>
                <td><span class="amount">${product.price}</span>
                </td>
            </tr>
            <tr class="cart-sellprice">
                <th>Sell Price</th>
                <td><span class="amount">${product.sellPrice}</span>
                </td>
            </tr>
            <tr class="cart-description">
                <th>Description</th>
                <td><span class="description">${product.description}</span>
                </td>
            </tr>
            <tr class="cart-quantity">
                <th>Quantity</th>
                <td><span class="quantity">${product.quantity}</span>
                </td>
            </tr>
            <tr class="cart-color">
                <th>Color</th>
                <td><span class="color">${product.color}</span>
                </td>
            </tr>
            <tr class="cart-weight">
                <th>Weight</th>
                <td><span class="weight">${product.weight}</span>
                </td>
            </tr>
            <tr class="cart-description">
                <th>Screen</th>
                <td><span class="Computer">${product.computer}</span>
                </td>
            </tr>
            </tfoot>
        </table>
    </div>
    </c:forEach>
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
                        <li><a href="#">Gaming Gear</a></li>
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

<!-- Slider -->
<script type="text/javascript" src="js/bxslider.min.js"></script>
<script type="text/javascript" src="js/script.slider.js"></script>

<script type="text/javascript" src="vendor/js/jquery.min.js"></script>
<script type="text/javascript" src="vendor/js/popper.min.js"></script>
<script type="text/javascript" src="vendor/js/bootstrap.min.js"></script>
<script type="text/javascript" src="vendor/js/mdb.min.js"></script>
<script type="text/javascript" src="vendor/datatables.min.js"></script>
</body>
</html>