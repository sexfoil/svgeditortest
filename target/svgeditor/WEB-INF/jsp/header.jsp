<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <title>SVG editor (Testcase for Slava Poliakov)</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="shortcut icon" href="img/favicon.png" type="image/png">

    <!-- Bootstrap -->
    <link href="css/bootstrap.css" rel="stylesheet">

    <!--Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Belgrano|Courgette&subset=latin,latin-ext' rel='stylesheet' type='text/css'>


    <!--Bootshape-->
    <link href="css/bootshape.css" rel="stylesheet">
    
  </head>
  <body>
    <!-- Navigation bar -->
    <div class="navbar navbar-default navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">SVG-files editor</a>
        </div>
        <nav role="navigation" class="collapse navbar-collapse navbar-right">
          <ul class="navbar-nav nav">
            <li class="dropdown">
              <a data-toggle="dropdown" href="" class="dropdown-toggle">File<b class="caret"></b></a>			  
				<ul class="dropdown-menu">
					<li>
						<form action="upload.edi" method="post" enctype="multipart/form-data">					    
							<input 	type="file" name="image" accept="image/svg+xml" id="upload" 
									class="hide" onchange="this.form.submit()"/>
							<label for="upload" >Import image</label>							
						</form>			
					</li>					
					<li id="download">						
						<label for="download" >
							<a href="download.edi" style="text-decoration: none; color:#303030;">Export image</a>
						</label>
					</li>					
				</ul>			  
            </li>
            <li><a>Edit</a></li>
            <li><a>Object</a></li>
            <li><a>View</a></li>
          </ul>
        </nav>
      </div>
    </div><!-- End Navigation bar -->

