webpackJsonp([37],{1383:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r(126),u=function(e){return e&&e.__esModule?e:{default:e}}(n),a=r(201),s=r(1992);t.default={namespace:"login",state:{},effects:{login:u.default.mark(function e(t,r){var n,o,c,i,f=t.payload,l=r.put,d=r.call,p=r.select;return u.default.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,d(s.login,f);case 2:return n=e.sent,e.next=5,p(function(e){return e.app});case 5:if(o=e.sent,c=o.locationQuery,!n.success){e.next=20;break}return i=c.from,e.next=11,l({type:"app/query"});case 11:if(!i||"/login"===i){e.next=16;break}return e.next=14,l(a.routerRedux.push(i));case 14:e.next=18;break;case 16:return e.next=18,l(a.routerRedux.push("/dashboard"));case 18:e.next=21;break;case 20:throw n;case 21:case"end":return e.stop()}},e,this)})}},e.exports=t.default},1992:function(e,t,r){"use strict";function n(e){return e&&e.__esModule?e:{default:e}}Object.defineProperty(t,"__esModule",{value:!0}),t.login=void 0;var u=r(126),a=n(u),s=r(304),o=n(s),c=(t.login=function(){var e=(0,o.default)(a.default.mark(function e(t){return a.default.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,c.request)({formUrlencoded:!0,url:f,method:"post",data:t}));case 1:case"end":return e.stop()}},e,this)}));return function(t){return e.apply(this,arguments)}}(),r(68)),i=c.config.api,f=i.userLogin}});