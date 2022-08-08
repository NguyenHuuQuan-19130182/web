<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
%>
<%--<jsp:useBean id="cart" scope="request" type="vn.edu.hcmuaf.fit.demo.beans.Cart"/>--%>
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
                    <li class="active"><a href="/demo/shop">Shop page</a></li>
                    <li><a href="/demo/Cart">Cart</a></li>
                    <li><a href="/demo/Contact">Contact</a></li>
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
                    <h2>Shop</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-2">
            <div class="single-sidebar">
                <h2 class="sidebar-title">Search Products</h2>
                <form action="Search" method="post">
                    <input type="text"  name="txt" class="form-control" aria-label="Small"
                           aria-describedby="inputGroup-sizing-sm"
                           placeholder="Search product ...">
                    <input type="submit" value="Search">
                </form>
            </div>

            <div class="single-sidebar">
                <h2 class="sidebar-title">Category</h2>
                <ul>
                    <c:forEach items="${category}" var="c">
                        <li class="list-group-item text-white ${tag == c.id ?"active":""}"><a href="category?cid=${c.id}">${c.name}</a></li>
                    </c:forEach></ul>
            </div>

        </div>


        <div class="js-glee-block">
            <div class="title_box_center wow">
                <h2 class="h_title">Laptop & PC</h2>
            </div>
            <!--title_box_center-->
        </div>
        <div class="js-glee-block">
            <div class="product-home" id="featured-cate-15">
                <jsp:useBean id="products" scope="request" type="java.util.List"/>
                <c:forEach items="${products}" var="p">
                    <div class="p-component">
                        <div class="p-img">
                            <a href="detail?id=${p.id}">
                                <img src="${p.img}">
                            </a>
                        </div>
                        <div class="p-info">
                            <a href="detail?id=${p.id}" class="p-name">${p.name}</a>
                            <span class="p-price"> ${p.price}</span>
                            <span class="p-mprice">${p.sellPrice} </span>
                        </div>
                        <div class="p-action">
                            <span class="p-qty"> <i class="fa fa-check" aria-hidden="true"></i> Còn hàng </span>
                            <a href="Add?id=${p.id}" data-id="876" class="p-buy icons js-buyNowAjax"></a>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
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
</body>
</html>