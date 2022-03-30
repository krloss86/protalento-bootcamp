<!-- HTML5 -->
<!DOCTYPE html>
<html lang="es">

<head>
	<!-- CSS only -->
	<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/estilos.css">
</head>

<body>
	<header>
	
	</header>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Navbar</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Link</a>
	        </li>
	        <li class="nav-item dropdown">
	          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	            Dropdown
	          </a>
	          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	            <li><a class="dropdown-item" href="#">Action</a></li>
	            <li><a class="dropdown-item" href="#">Another action</a></li>
	            <li><hr class="dropdown-divider"></li>
	            <li><a class="dropdown-item" href="#">Something else here</a></li>
	          </ul>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link disabled">Disabled</a>
	        </li>
	      </ul>
	      <form class="d-flex">
	        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Search</button>
	      </form>
	    </div>
	  </div>
	</nav>

	<main>
		<div class="container">
			<div class="row">
				<div class="col-sm-11 col-md-10 col-lg-8 col-xl-6 col-xxl-4">
					<form>
						  <div class="mb-3">
						    <label for="exampleInputEmail1" class="form-label">Email address</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
						    <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
						  </div>
						  <div class="mb-3">
						    <label for="exampleInputPassword1" class="form-label">Password</label>
						    <input type="password" class="form-control" id="exampleInputPassword1">
						  </div>
						  <div class="mb-3 form-check">
						    <input type="checkbox" class="form-check-input" id="exampleCheck1">
						    <label class="form-check-label" for="exampleCheck1">Check me out</label>
						  </div>
						  <button type="submit" class="btn btn-primary">Submit</button>
						</form>
				</div>
				<div class="col">
					<form class="row g-3 needs-validation" novalidate>
					  <div class="col-md-4">
					    <label for="validationCustom01" class="form-label">First name</label>
					    <input type="text" class="form-control" id="validationCustom01" value="Mark" required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustom02" class="form-label">Last name</label>
					    <input type="text" class="form-control" id="validationCustom02" value="Otto" required>
					    <div class="valid-feedback">
					      Looks good!
					    </div>
					  </div>
					  <div class="col-md-4">
					    <label for="validationCustomUsername" class="form-label">Username</label>
					    <div class="input-group has-validation">
					      <span class="input-group-text" id="inputGroupPrepend">@</span>
					      <input type="text" class="form-control" id="validationCustomUsername" aria-describedby="inputGroupPrepend" required>
					      <div class="invalid-feedback">
					        Please choose a username.
					      </div>
					    </div>
					  </div>
					  <div class="col-md-6">
					    <label for="validationCustom03" class="form-label">City</label>
					    <input type="text" class="form-control" id="validationCustom03" required>
					    <div class="invalid-feedback">
					      Please provide a valid city.
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom04" class="form-label">State</label>
					    <select class="form-select" id="validationCustom04" required>
					      <option selected disabled value="">Choose...</option>
					      <option>...</option>
					    </select>
					    <div class="invalid-feedback">
					      Please select a valid state.
					    </div>
					  </div>
					  <div class="col-md-3">
					    <label for="validationCustom05" class="form-label">Zip</label>
					    <input type="text" class="form-control" id="validationCustom05" required>
					    <div class="invalid-feedback">
					      Please provide a valid zip.
					    </div>
					  </div>
					  <div class="col-12">
					    <div class="form-check">
					      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
					      <label class="form-check-label" for="invalidCheck">
					        Agree to terms and conditions
					      </label>
					      <div class="invalid-feedback">
					        You must agree before submitting.
					      </div>
					    </div>
					  </div>
					  <div class="col-12">
					    <button class="btn btn-primary" type="submit">Submit form</button>
					  </div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>