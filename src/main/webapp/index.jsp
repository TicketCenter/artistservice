<!DOCTYPE html>
<html>
<head>
    <title>Artists Service API</title>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="Artists Service API">
    <meta name="author" content="TicketCenter">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.2/jquery-ui.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>Artist Service <small>API Reference</small></h1>
        <p>An overview of all the available sources. Click on a specific source for more information about that source.</p>
    </div>
    <h4>Concerts</h4>
    <div class="panel-group" id="accordionOne" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionOne" href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">/api/concerts</a>
                </h4>
            </div>
            <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body">
                    <p>An overview of the source. Filters can be combined.</p>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Source</th>
                            <th>Filter options</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><a href="/api/concerts" target="_blank">/api/concerts</a></td>
                            <td></td>
                            <td>Gets all concerts.</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/concerts?location=Netherlands" target="_blank">location={location}</a></td>
                            <td>Gets all concerts filtered on location.</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/concerts?page_size=10" target="_blank">page_size={page_size}</a></td>
                            <td>Gets all concerts filtered on page size.</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/concerts?page_number=1" target="_blank">page_number={page_number}</a></td>
                            <td>Gets all concerts filtered on page number</td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="small"><em><strong>Example:</strong> <a href="/api/concerts?location=Netherlands&page_size=10&page_number=1" target="_blank">/api/concerts?location=Netherlands&page_size=10&page_number=1</a></em></p>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingTwo">
                <h4 class="panel-title">
                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionOne" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">/api/concerts/{id}</a>
                </h4>
            </div>
            <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                <div class="panel-body">
                    <p>An overview of the source. Filters can be combined.</p>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Source</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><a href="/api/concerts/E0-001-075694702-5" target="_blank">/api/concerts/{id}</a></td>
                            <td>Gets a specific concert.</td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="small"><em><strong>Example:</strong> <a href="api/concerts/E0-001-075694702-5" target="_blank">/api/concerts/E0-001-075694702-5</a></em></p>
                </div>
            </div>
        </div>
    </div>
    <h4>Artists</h4>
    <div class="panel-group" id="accordionTwo" role="tablist" aria-multiselectable="true">
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingThree">
                <h4 class="panel-title">
                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionTwo" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">/api/artists</a>
                </h4>
            </div>
            <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                <div class="panel-body">
                    <p>An overview of the source. Filters can be combined.</p>
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Source</th>
                            <th>Filter options</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><a href="/api/artists" target="_blank">/api/artists</a></td>
                            <td></td>
                            <td>Gets all artists (filtered on character <em>a</em> by default).</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/artists?characters=a" target="_blank">characters={characters}</a></td>
                            <td>Gets all artists filtered on characters.</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/artists?page_size=10" target="_blank">page_size={page_size}</a></td>
                            <td>Gets all artists filtered on page size.</td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><a href="/api/artists?page_number=1" target="_blank">page_number={page_number}</a></td>
                            <td>Gets all artists filtered on page number</td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="small"><em><strong>Example:</strong> <a href="/api/artists?characters=a&page_size=10&page_number=1" target="_blank">/api/artists?characters=a&page_size=10&page_number=1</a></em></p>
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="headingFour">
                <h4 class="panel-title">
                    <a class="collapsed" data-toggle="collapse" data-parent="#accordionTwo" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">/api/artists/{name}</a>
                </h4>
            </div>
            <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
                <div class="panel-body">
                    <table class="table">
                        <thead>
                        <tr>
                            <th>Source</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td><a href="/api/artists/Cher" target="_blank">/api/artists/{name}</a></td>
                            <td>Gets a specific artist.</td>
                        </tr>
                        </tbody>
                    </table>
                    <p class="small"><em><strong>Example:</strong> <a href="/api/artists/Cher" target="_blank">/api/artists/Cher</a></em></p>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
