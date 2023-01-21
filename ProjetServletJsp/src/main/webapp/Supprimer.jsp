<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!doctype html>
<html lang="en">
<head>
<title>TypeReclamation</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section"></h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-10 col-md-12">
					<div class="wrapper">
						<div class="row no-gutters">
							<div class="col-md-7 d-flex align-items-stretch">
								<div class="contact-wrap w-100 p-md-5 p-4">
									<h3 class="mb-4">Voulez vous supprimer la Reclamation</h3>
									<div id="form-message-warning" class="mb-4"></div>
									<div id="form-message-success" class="mb-4">Your message
										was sent, thank you!</div>
									<form method="POST" id="contactForm" name="contactForm">
							<div class="btn-group">
 
										<div class="row">
											<div class="col-md-6">
											
													
		<input  type="submit" name="action" value="Oui"class="btn btn-primary"/>
		
		
		<br><br>
				<input  type="submit" name="action" value="Non"class="btn btn-primary"/>
		
									
											</div>

											</div>
											
											<div class="col-md-12">
												<div class="form-group">
													
													<div class="submitting"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div class="col-md-5 d-flex align-items-stretch">
								<div class="info-wrap bg-primary w-100 p-lg-5 p-4">
									<h3 class="mb-4 mt-md-4">Bienvenue ${nom} ${prenom}</h3>
									<div class="dbox w-100 d-flex align-items-start">
										<div
											class="icon d-flex align-items-center justify-content-center">
											<span class="fa fa-map-marker"></span>
										</div>
										<div class="text pl-3">
											<p>
												<span>Address:</span> Enit,El Manar
											</p>
										</div>
									</div>
									<div class="dbox w-100 d-flex align-items-center">
										<div
											class="icon d-flex align-items-center justify-content-center">
											<span class="fa fa-phone"></span>
										</div>
										<div class="text pl-3">
											<p>
												<span>Phone:</span> <a href="tel://1234567920">+ 216 56674932</a>
											</p>
										</div>
									</div>
									<div class="dbox w-100 d-flex align-items-center">
										<div
											class="icon d-flex align-items-center justify-content-center">
											<span class="fa fa-paper-plane"></span>
										</div>
										<div class="text pl-3">
											<p>
												<span>Email:</span> <a href="mailto:info@yoursite.com">ihebkesraoui@gmail.com</a>
											</p>
										</div>
									</div>
									<div class="dbox w-100 d-flex align-items-center">
										<div
											class="icon d-flex align-items-center justify-content-center">
											<span class="fa fa-globe"></span>
										</div>
										<div class="text pl-3">
											<p>
												<span>Website</span> <a href="#">ihebkesraoui.com</a>
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

		<script src="js/jquery.min.js"></script>
  <script src="js/popper.js"></script>
  <script src="js/bootstrap.min.js"></script>

</body>
</html>


