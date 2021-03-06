/**
 * jquery-restable - jQuery plugin that make tables responsive
 * @version v0.1.2
 * @link http://codeb.it/restable/
 * @license MIT
 */
!function(t,e,n)
{"use strict";t.fn.ReStable=function(i){
	function h(e,n){var i,h=[],a={},s=t(e).find("tr").first().children("td,th"),c=0;return l.rowHeaders&&(s=s.slice(1)),s.each(function(){h.push(t(this).text())}),t(e).find("tr").slice(1).each(function(){var e=t(this);c+=1,t.each(h,function(t,n){t+=1,l.rowHeaders?(a[n]||(a[n]={}),l.keepHtml?a[n][e.children("td:nth-child(1)").html()]=e.children("td:nth-child("+(t+1)+")").html():a[n][e.children("td:nth-child(1)").text()]=e.children("td:nth-child("+(t+1)+")").text()):(a[c]||(a[c]={}),a[c][n]=l.keepHtml?e.children("td:nth-child("+t+")").html():e.children("td:nth-child("+t+")").text())})}),i=t("<ul/>",{"class":"tabletolist "+(l.rowHeaders?"rh":"nrh"),id:"tabletolist"+n}).insertBefore(t(e)),t.each(a,function(e,n){var h=t("<li/>",{html:l.rowHeaders?'<span class="titles">'+e+"</span>":""}).appendTo(i),a=t("<ul/>").appendTo(h);t.each(n,function(e,n){t("<li/>",{"class":"cf",html:'<span class="row_headers">'+e+'</span> <span class="row_data '+(l.keepHtml?"html":"")+'">'+n+"</span>"}).appendTo(a)})}),i}var l=t.extend({rowHeaders:!0,maxWidth:480,keepHtml:!1},i);this.each(function(){function i(){t(e).width()>parseInt(l.maxWidth,10)?(t(s).show(),a&&t(a).hide()):(t(s).hide(),a?t(a).show():a=h(s,n))}var a,s=t(this);n+=1,i(),t(e).resize(function(){i()})})},t.ReStable=function(e){t("table").ReStable(e)}}(jQuery,this,0);