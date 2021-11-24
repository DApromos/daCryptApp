<!DOCTYPE html>
<html>
<body>

<h2>Real Time Exchange Rate</h2>
<br>


<table>
    <tr>
        <th>From Currency</th>
        <th>To Currency</th>
        <th>Exchange Rate</th>
        <th>Last Refreshed</th>
        <th>Bid Price</th>
        <th>Ask Price</th>
    </tr>

    <c:forEach var="currencyPare" items="${realTimeExRates}">

        <tr>
            <td>${currencyPare.fromCurrencyFullName}</td>
            <td>${currencyPare.toCurrencyFullName}</td>
            <td>${currencyPare.exchangeRate}</td>
            <td>${currencyPare.lastRefreshed}</td>
            <td>${currencyPare.bidPrice}</td>
            <td>${currencyPare.askPrice}</td>
        </tr>

    </c:forEach>


</table>

<br>

<input type="button" value="Refresh"
       onclick="window.location.href = 'addNewPare'"/>

</body>
</html>