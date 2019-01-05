$(function() {

	Morris.Area({
        element: 'morris-area-chart',
        data: [{
            period: '2016 Q1',
            Member: 102,
            Product: 53,
            Deal: 21
        }, {
            period: '2016 Q2',
            Member: 215,
            Product: 113,
            Deal: 71
        }, {
            period: '2016 Q3',
            Member: 395,
            Product: 209,
            Deal: 199
        }, {
            period: '2016 Q4',
            Member: 891,
            Product: 403,
            Deal: 301
        }, {
            period: '2017 Q1',
            Member: 1305,
            Product: 553,
            Deal: 396
        }, {
            period: '2017 Q2',
            Member: 1984,
            Product: 891,
            Deal: 887
        }, {
            period: '2017 Q3',
            Member: 1504,
            Product: 525,
            Deal: 656
        }, {
            period: '2017 Q4',
            Member: 2525,
            Product: 1784,
            Deal: 1253
        }, {
            period: '2018 Q1',
            Member: 3685,
            Product: 1984,
            Deal: 1654
        }, {
            period: '2018 Q2',
            Member: 3001,
            Product: 1895,
            Deal: 1692
        },{
            period: '2018 Q3',
            Member: 2809,
            Product: 1795,
            Deal: 1392
        },{
            period: '2018 Q4',
            Member: 3301,
            Product: 2095,
            Deal: 1992
        }],
        xkey: 'period',
        ykeys: ['Member', 'Product', 'Deal'],
        labels: ['Member', 'Product', 'Deal'],
        pointSize: 2,
        hideHover: 'auto',
        resize: true
    });
    
    Morris.Donut({
        
    });


    Morris.Bar({
        element: 'morris-bar-chart',
        data: [{
            y: '2006',
            a: 100,
            b: 90
        }, {
            y: '2007',
            a: 75,
            b: 65
        }, {
            y: '2008',
            a: 50,
            b: 40
        }, {
            y: '2009',
            a: 75,
            b: 65
        }, {
            y: '2010',
            a: 50,
            b: 40
        }, {
            y: '2011',
            a: 75,
            b: 65
        }, {
            y: '2012',
            a: 100,
            b: 90
        }],
        xkey: 'y',
        ykeys: ['a', 'b'],
        labels: ['Series A', 'Series B'],
        hideHover: 'auto',
        resize: true
    });
    
});
