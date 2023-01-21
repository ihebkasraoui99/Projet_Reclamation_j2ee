<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<!doctype html>
<html lang="en">
<head>
<title>Add Reclamation</title>
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
									<h3 class="mb-4">Ecrire votre Reclamation</h3>
									<div id="form-message-warning" class="mb-4"></div>
									<div id="form-message-success" class="mb-4">Your message
										was sent, thank you!</div>
									<form method="POST" id="contactForm" name="contactForm">
										<div class="dropdown">
											<button class="btn btn-secondary dropdown-toggle"
												type="button" id="dropdownMenuButton" data-toggle="dropdown"
												aria-haspopup="true" aria-expanded="false">Type</button>
											<div class="dropdown-menu"
												aria-labelledby="dropdownMenuButton">
												<c:forEach items="${typereclamation}" var="re">
													<a
														href="/ProjetServletJsp/ModifierReclamation?id=${l}&x=${re.getType()}">${re.getType()}</a>

												</c:forEach>
											</div>
										</div>

								
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<input type="text" class="form-control" name="titre"
														id="titre" placeholder="Titre">
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<textarea name="desc" class="form-control" id="desc"
														cols="30" rows="7" placeholder="Description"></textarea>
												</div>
											</div>

											<div class="col-md-12">
												<div class="form-group">
													<input type="submit" name="action" value="Modifier Reclamation"
														class="btn btn-primary" />
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
												<span>Phone:</span> <a href="tel://1234567920">+ 216
													56674932</a>
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


