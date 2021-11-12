<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.4.0/chart.min.js"
	integrity="sha512-JxJpoAvmomz0MbIgw9mx+zZJLEvC6hIgQ6NcpFhVmbK1Uh5WynnRTTSGv3BTZMNBpPbocmdSJfldgV5lVnPtIw=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	var myChartOne = document.getElementById('myChart1');
	var myChartTwo = document.getElementById('myChart2');

	const myChartOneLabels = [ "Janeiro", "Fevereiro", "Março", "Abril",
			"Maio", "Junho" ];
	const myChartOneData = {
		labels : myChartOneLabels,
		datasets : [ {
			label : 'Medição',
			data : [ 24.6, 28.9, 30.4, 23.5, 24.4, 23.8 ],
			borderColor : 'rgb(255, 99, 132)',
			backgroundColor : 'rgba(255, 99, 132, 0.5)',
		} ]
	};

	const myChartOneConfig = {
		type : 'line',
		data : myChartOneData,
		options : {
			responsive : true,
			plugins : {
				legend : {
					position : 'top',
				},
				title : {
					display : true,
					text : 'Medição 1'
				}
			}
		},
	};

	new Chart(myChartOne, myChartOneConfig);
	new Chart(myChartTwo, myChartOneConfig);
</script>