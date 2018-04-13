<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title> Cadastro Pais</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
   
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Cadastro</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="index.html">Pais</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Pais</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="ManterPais.do" method="post">
            
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Pais</label>
                    <input type="text" class="form-control" name="nome"  placeholder="Pais">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="area">Area</label>
                    <input type="text" class="form-control" name="area"   placeholder="Area do Pais">
                </div>

                <div class="form-group col-md-6">
                    <label for="populacao">Populacao</label>
                    <input type="text" class="form-control" name="populacao"  placeholder="População do Pais">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" >Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>

