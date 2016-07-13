
$(function () {
	//折线和柱状图
    var chart;
    $(document).ready(function() {
        chart = new Highcharts.Chart({
            chart: {
                renderTo: 'container2',
                zoomType: 'xy'
            },
            title: {
                text: '宠物疾病症状统计'//Average Monthly Temperature and Rainfall in Tokyo
            },
            subtitle: {
                text: '数据来源：宠物疾病诊断系统'//Source: WorldClimate.com
            },
            xAxis: [{                                                   //x轴数据
                categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
                    'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec']
            }],
            yAxis: [{ // Primary yAxis
                labels: {
                    formatter: function() {
                        return this.value +'%';//最左边y轴数据
                    },
                    style: {
                        color: '#89A54E'
                    }
                },
                title: {
                    text: '痊愈率',//最左边标题
                    style: {
                        color: '#89A54E'
                    }
                }
            }, { // Secondary yAxis
                title: {
                    text: '访病数量',//最右边标题
                    style: {
                        color: '#4572A7'
                    }
                },
                labels: {
                    formatter: function() {
                        return this.value;//最右边y轴
                    },
                    style: {
                        color: '#4572A7'
                    }
                },
                opposite: true
            }],
            tooltip: {
                formatter: function() {
                    return ''+
                        this.x +': '+ this.y +
                        (this.series.name == '访病数量' ? ' 次' : '%');
                }
            },
            legend: {
                layout: 'vertical',
                align: 'left',
                x: 120,
                verticalAlign: 'top',
                y: 100,
                floating: true,
                backgroundColor: '#FFFFFF'//左中位置圆角矩形
            },
            series: [{
                name: '访病数量',			//柱状图数据等设计
                color: '#4572A7',
                type: 'column',
                yAxis: 1,
                data: [173, 185, 224, 197, 235, 200,211 , 188, 199,217,206,198]
    
            }, {
                name: '痊愈率',//折线数据等数据设计
                color: '#89A54E',
                type: 'spline',
                data: [89, 91, 90, 92,91, 91, 90, 91, 91,92,90,91]
            }]
        });
    });
    
    
    //饼图
    $(function () {
	    var chart;
	    $(document).ready(function() {
	        chart = new Highcharts.Chart({
	            chart: {
	                renderTo: 'container1',
	                plotBackgroundColor: null,
	                plotBorderWidth: null,
	                plotShadow: false
	            },
	            title: {
	                text: '问题解决情况统计图表'
	            },
	            tooltip: {
	                formatter: function() {
	                    return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
	                }
	            },
	            plotOptions: {
	                pie: {
	                    allowPointSelect: true,
	                    cursor: 'pointer',
	                    dataLabels: {
	                        enabled: true,
	                        color: '#000000',
	                        connectorColor: '#000000',
	                        formatter: function() {
	                            return '<b>'+ this.point.name +'</b>: '+ this.percentage +' %';
	                        }
	                    }
	                }
	            },
	            series: [{
	                type: 'pie',
	                name: 'Browser share',
	                data: [
	                    ['已解决', 34.4 ],
	                    ['待解决', 28.6 ],
	                    ['其他',   10.7],
	                 
	                    {
	                        name: '未解决',
	                        y: 26.3,
	                        sliced: true,
	                        selected: true
	                    }
//	                    ['Safari',    8.5],
//	                    ['Opera',     14.7],

	                ]
	            }]
	        });
	    });
	    
	});
	
	$(function() {
	var chart;
	$(document).ready(function() {
		chart = new Highcharts.Chart({
			chart: {
				renderTo: 'container3',
				type: 'area'
			},
			title: {
				text: '网站访问统计'
			},
			subtitle: {
				text: 'Source:宠物疾病统计管理系统'
			},
			xAxis: {
				labels: {
					formatter: function() {
						return this.value; // clean, unformatted number for year
					}
				}
			},
			yAxis: {
				title: {
					text: '访问人数和提问次数'
				},
				labels: {
					formatter: function() {
						return this.value / 1000 + 'k';
					}
				}
			},
			tooltip: {
				formatter: function() {
					return this.series.name + '<b>' +
						Highcharts.numberFormat(this.y, 0) + '</b><br/>days in ' + this.x;
				}
			},
			plotOptions: {
				area: {
					pointStart: 0,
					marker: {
						enabled: false,
						symbol: 'circle',
						radius: 2,
						states: {
							hover: {
								enabled: true
							}
						}
					}
				}
			},
			series: [{
				name: '访问量',
				data: [
					112,345,245,305,432,534,351,455,566,641,
					454,523,578,689,785,941,1014,1214,1324,1254,
					1541,1231,1324,1254,1236,1752,1246,1254,1268,1596,
					2154
				]
			}, {
				name: '提问次数',
				data: [
//							    null, null, null, null, null, null, null, null, null, null,
//								5, 25, 5, 10, 10, 20, 46, 60, 89, 100, 105, 271, 322,
//								428, 521, 629, 709, 839, 939, 1058, 1143, 1392, 1478,
//								1515, 1735, 1955, 2125, 2304, 2593, 2735, 3062, 3249,
//								3352, 3504, 3741, 3997, 4500, 4300, 4100, 3900, 3700
////								,3500, 3300, 3100, 2900, 2700, 2500, 2400, 2300, 2200,
////								2100, 2000, 1900, 1800, 1800, 1700, 1600

					52,162,112,177,203,241,181,198,272,396,
					304,223,352,405,554,515,652,701,612,746,
					894,612,725,699,761,795,812,860,932,1001,
					1654
				]
			}]
		});
	});

});
});