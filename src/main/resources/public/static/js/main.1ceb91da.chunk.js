(this.webpackJsonpfrontend=this.webpackJsonpfrontend||[]).push([[0],{25:function(e,t,a){},26:function(e,t,a){},28:function(e,t,a){},35:function(e,t,a){},36:function(e,t,a){},37:function(e,t,a){},38:function(e,t,a){},39:function(e,t,a){},40:function(e,t,a){},41:function(e,t,a){"use strict";a.r(t);var c=a(1),n=a.n(c),s=a(18),r=a.n(s),i=(a(25),a(26),a(4)),l=a(2),o=a(8),m=a.n(o),h=a(10),j=a(11),d=(a(28),a(0)),u=function(e){var t=e.teamName,a=e.match;if(!a)return null;var c=a.homeTeam===t?a.awayTeam:a.homeTeam,n="/teams/".concat(c),s=t===a.matchWinner;return Object(d.jsxs)("div",{className:s?"MatchDetailCard won-card":"MatchDetailCard lost-card",children:[Object(d.jsxs)("div",{children:[Object(d.jsx)("span",{className:"vs",children:"vs"}),Object(d.jsx)("h1",{children:Object(d.jsx)(i.b,{to:n,children:c})}),Object(d.jsxs)("h2",{className:"match-date",children:["Date: ",a.date]}),Object(d.jsxs)("h3",{className:"match-result",children:["Score: ",a.fullTimeHomeGoal,"-",a.fullTimeAwayGoal]})]}),Object(d.jsxs)("div",{className:"additional-detail",children:[Object(d.jsxs)("h3",{children:[a.homeTeam," last 5 matches"]}),Object(d.jsxs)("p",{children:[a.homeMatch1,"  ",a.homeMatch2,"  ",a.homeMatch3,"  ",a.homeMatch4,"  ",a.homeMatch5]}),Object(d.jsxs)("h3",{children:[a.awayTeam," last 5 matches"]}),Object(d.jsxs)("p",{children:[a.awayMatch1,"  ",a.awayMatch2,"  ",a.awayMatch3,"  ",a.awayMatch4,"  ",a.awayMatch5]})]})]})},b=(a(35),function(e){var t=e.match,a=e.teamName;if(!t)return null;var c=t.homeTeam===a?t.awayTeam:t.homeTeam,n="/teams/".concat(c),s=a===t.matchWinner;return Object(d.jsxs)("div",{className:s?"MatchSmallCard won-card":"MatchSmallCard lost-card",children:[Object(d.jsx)("span",{className:"vs",children:"vs"}),Object(d.jsx)("h1",{children:Object(d.jsx)(i.b,{to:n,children:c})}),Object(d.jsxs)("h2",{children:["Date: ",t.date]}),Object(d.jsxs)("h3",{className:"match-result",children:["Score: ",t.fullTimeHomeGoal," - ",t.fullTimeAwayGoal," "]})]})}),O=(a(36),a(20)),x=function(){var e=Object(c.useState)({matches:[]}),t=Object(j.a)(e,2),a=t[0],n=t[1],s=Object(l.f)().teamName;return Object(c.useEffect)((function(){(function(){var e=Object(h.a)(m.a.mark((function e(){var t,a;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("".concat("","/team/").concat(s));case 2:return t=e.sent,e.next=5,t.json();case 5:a=e.sent,console.log(a),n(a);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()()}),[s]),a&&a.teamName?Object(d.jsxs)("div",{className:"TeamPage",children:[Object(d.jsx)("div",{className:"team-name-section",children:Object(d.jsx)("h1",{className:"team-name",children:a.teamName})}),Object(d.jsxs)("div",{className:"win-loss-draw-section",children:["Wins / Losses / Draws",Object(d.jsx)(O.PieChart,{data:[{title:"Losses",value:a.totalLosses,color:"#a34d5d"},{title:"Wins",value:a.totalWins,color:"#4da375"},{title:"Draws",value:a.totalMatches-(a.totalWins+a.totalLosses),color:"#979797"}]}),";"]}),Object(d.jsxs)("div",{className:"match-detail-section",children:[Object(d.jsx)("h3",{children:"Latest Matches"}),Object(d.jsx)(u,{teamName:a.teamName,match:a.matches[0]})]}),a.matches.slice(1).map((function(e){return Object(d.jsx)(b,{teamName:a.teamName,match:e},e.id)})),Object(d.jsx)("div",{className:"more-link",children:Object(d.jsx)(i.b,{to:"/teams/".concat(s,"/matches/").concat("2018"),children:" More >"})})]}):Object(d.jsx)("h1",{children:"Team Not Found"})},f=(a(37),a(38),function(e){var t=e.teamName;console.log(t);var a=[],c="2000";console.log(c);for(var n=c;n<="2018";n++)a.push(n);return Object(d.jsx)("ul",{className:"YearSelector",children:a.map((function(e){return Object(d.jsx)("li",{children:Object(d.jsxs)(i.b,{to:"/teams/".concat(t,"/matches/").concat(e),children:[e," - ",parseInt(e)+1]})},e)}))})}),v=function(){var e=Object(c.useState)([]),t=Object(j.a)(e,2),a=t[0],n=t[1],s=Object(l.f)(),r=s.teamName,i=s.year;return Object(c.useEffect)((function(){(function(){var e=Object(h.a)(m.a.mark((function e(){var t,a;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("".concat("","/team/").concat(r,"/matches?year=").concat(i));case 2:return t=e.sent,e.next=5,t.json();case 5:a=e.sent,console.log(a),n(a);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()()}),[r,i]),Object(d.jsxs)("div",{className:"MatchPage",children:[Object(d.jsxs)("div",{className:"year-selector",children:[Object(d.jsx)("h3",{children:"Select Year"}),Object(d.jsx)(f,{teamName:r})]}),Object(d.jsxs)("div",{children:[Object(d.jsxs)("h1",{className:"page-heading",children:[r," matches in ",i," - ",parseInt(i)+1]}),a.map((function(e){return Object(d.jsx)(u,{teamName:r,match:e},e.id)}))]})]})},N=(a(39),a(40),function(e){var t=e.teamName;return Object(d.jsx)("div",{className:"TeamTile",children:Object(d.jsx)("h1",{children:Object(d.jsx)(i.b,{to:"/teams/".concat(t),children:t})})})}),p=function(){var e=Object(c.useState)([]),t=Object(j.a)(e,2),a=t[0],n=t[1];return Object(c.useEffect)((function(){(function(){var e=Object(h.a)(m.a.mark((function e(){var t,a;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,fetch("".concat("","/team"));case 2:return t=e.sent,e.next=5,t.json();case 5:a=e.sent,console.log(a),n(a);case 8:case"end":return e.stop()}}),e)})));return function(){return e.apply(this,arguments)}})()()}),[]),Object(d.jsx)("div",{className:"HomePage",children:Object(d.jsxs)("div",{className:"header-section",children:[Object(d.jsx)("h1",{className:"app_name",children:"English Premier League Dashboard"}),Object(d.jsx)("div",{className:"team-grid",children:a.map((function(e){return Object(d.jsx)(N,{teamName:e.teamName},e.id)}))})]})})};var w=function(){return Object(d.jsx)("div",{className:"App",children:Object(d.jsx)(i.a,{children:Object(d.jsxs)(l.c,{children:[Object(d.jsx)(l.a,{path:"/teams/:teamName/matches/:year",children:Object(d.jsx)(v,{})}),Object(d.jsx)(l.a,{path:"/teams/:teamName",children:Object(d.jsx)(x,{})}),Object(d.jsx)(l.a,{path:"/",children:Object(d.jsx)(p,{})})]})})})},g=function(e){e&&e instanceof Function&&a.e(3).then(a.bind(null,42)).then((function(t){var a=t.getCLS,c=t.getFID,n=t.getFCP,s=t.getLCP,r=t.getTTFB;a(e),c(e),n(e),s(e),r(e)}))};r.a.render(Object(d.jsx)(n.a.StrictMode,{children:Object(d.jsx)(w,{})}),document.getElementById("root")),g()}},[[41,1,2]]]);
//# sourceMappingURL=main.1ceb91da.chunk.js.map