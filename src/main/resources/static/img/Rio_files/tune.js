parcelRequire=function(e,r,t,n){var i,o="function"==typeof parcelRequire&&parcelRequire,u="function"==typeof require&&require;function f(t,n){if(!r[t]){if(!e[t]){var i="function"==typeof parcelRequire&&parcelRequire;if(!n&&i)return i(t,!0);if(o)return o(t,!0);if(u&&"string"==typeof t)return u(t);var c=new Error("Cannot find module '"+t+"'");throw c.code="MODULE_NOT_FOUND",c}p.resolve=function(r){return e[t][1][r]||r},p.cache={};var l=r[t]=new f.Module(t);e[t][0].call(l.exports,p,l,l.exports,this)}return r[t].exports;function p(e){return f(p.resolve(e))}}f.isParcelRequire=!0,f.Module=function(e){this.id=e,this.bundle=f,this.exports={}},f.modules=e,f.cache=r,f.parent=o,f.register=function(r,t){e[r]=[function(e,r){r.exports=t},{}]};for(var c=0;c<t.length;c++)try{f(t[c])}catch(e){i||(i=e)}if(t.length){var l=f(t[t.length-1]);"object"==typeof exports&&"undefined"!=typeof module?module.exports=l:"function"==typeof define&&define.amd?define(function(){return l}):n&&(this[n]=l)}if(parcelRequire=f,i)throw i;return f}({"QVnC":[function(require,module,exports) {
var t=function(t){"use strict";var r,e=Object.prototype,n=e.hasOwnProperty,o="function"==typeof Symbol?Symbol:{},i=o.iterator||"@@iterator",a=o.asyncIterator||"@@asyncIterator",c=o.toStringTag||"@@toStringTag";function u(t,r,e,n){var o=r&&r.prototype instanceof v?r:v,i=Object.create(o.prototype),a=new k(n||[]);return i._invoke=function(t,r,e){var n=f;return function(o,i){if(n===l)throw new Error("Generator is already running");if(n===p){if("throw"===o)throw i;return N()}for(e.method=o,e.arg=i;;){var a=e.delegate;if(a){var c=_(a,e);if(c){if(c===y)continue;return c}}if("next"===e.method)e.sent=e._sent=e.arg;else if("throw"===e.method){if(n===f)throw n=p,e.arg;e.dispatchException(e.arg)}else"return"===e.method&&e.abrupt("return",e.arg);n=l;var u=h(t,r,e);if("normal"===u.type){if(n=e.done?p:s,u.arg===y)continue;return{value:u.arg,done:e.done}}"throw"===u.type&&(n=p,e.method="throw",e.arg=u.arg)}}}(t,e,a),i}function h(t,r,e){try{return{type:"normal",arg:t.call(r,e)}}catch(n){return{type:"throw",arg:n}}}t.wrap=u;var f="suspendedStart",s="suspendedYield",l="executing",p="completed",y={};function v(){}function d(){}function g(){}var m={};m[i]=function(){return this};var w=Object.getPrototypeOf,L=w&&w(w(G([])));L&&L!==e&&n.call(L,i)&&(m=L);var x=g.prototype=v.prototype=Object.create(m);function E(t){["next","throw","return"].forEach(function(r){t[r]=function(t){return this._invoke(r,t)}})}function b(t,r){var e;this._invoke=function(o,i){function a(){return new r(function(e,a){!function e(o,i,a,c){var u=h(t[o],t,i);if("throw"!==u.type){var f=u.arg,s=f.value;return s&&"object"==typeof s&&n.call(s,"__await")?r.resolve(s.__await).then(function(t){e("next",t,a,c)},function(t){e("throw",t,a,c)}):r.resolve(s).then(function(t){f.value=t,a(f)},function(t){return e("throw",t,a,c)})}c(u.arg)}(o,i,e,a)})}return e=e?e.then(a,a):a()}}function _(t,e){var n=t.iterator[e.method];if(n===r){if(e.delegate=null,"throw"===e.method){if(t.iterator.return&&(e.method="return",e.arg=r,_(t,e),"throw"===e.method))return y;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return y}var o=h(n,t.iterator,e.arg);if("throw"===o.type)return e.method="throw",e.arg=o.arg,e.delegate=null,y;var i=o.arg;return i?i.done?(e[t.resultName]=i.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=r),e.delegate=null,y):i:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,y)}function j(t){var r={tryLoc:t[0]};1 in t&&(r.catchLoc=t[1]),2 in t&&(r.finallyLoc=t[2],r.afterLoc=t[3]),this.tryEntries.push(r)}function O(t){var r=t.completion||{};r.type="normal",delete r.arg,t.completion=r}function k(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(j,this),this.reset(!0)}function G(t){if(t){var e=t[i];if(e)return e.call(t);if("function"==typeof t.next)return t;if(!isNaN(t.length)){var o=-1,a=function e(){for(;++o<t.length;)if(n.call(t,o))return e.value=t[o],e.done=!1,e;return e.value=r,e.done=!0,e};return a.next=a}}return{next:N}}function N(){return{value:r,done:!0}}return d.prototype=x.constructor=g,g.constructor=d,g[c]=d.displayName="GeneratorFunction",t.isGeneratorFunction=function(t){var r="function"==typeof t&&t.constructor;return!!r&&(r===d||"GeneratorFunction"===(r.displayName||r.name))},t.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,g):(t.__proto__=g,c in t||(t[c]="GeneratorFunction")),t.prototype=Object.create(x),t},t.awrap=function(t){return{__await:t}},E(b.prototype),b.prototype[a]=function(){return this},t.AsyncIterator=b,t.async=function(r,e,n,o,i){void 0===i&&(i=Promise);var a=new b(u(r,e,n,o),i);return t.isGeneratorFunction(e)?a:a.next().then(function(t){return t.done?t.value:a.next()})},E(x),x[c]="Generator",x[i]=function(){return this},x.toString=function(){return"[object Generator]"},t.keys=function(t){var r=[];for(var e in t)r.push(e);return r.reverse(),function e(){for(;r.length;){var n=r.pop();if(n in t)return e.value=n,e.done=!1,e}return e.done=!0,e}},t.values=G,k.prototype={constructor:k,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=r,this.done=!1,this.delegate=null,this.method="next",this.arg=r,this.tryEntries.forEach(O),!t)for(var e in this)"t"===e.charAt(0)&&n.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=r)},stop:function(){this.done=!0;var t=this.tryEntries[0].completion;if("throw"===t.type)throw t.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function o(n,o){return c.type="throw",c.arg=t,e.next=n,o&&(e.method="next",e.arg=r),!!o}for(var i=this.tryEntries.length-1;i>=0;--i){var a=this.tryEntries[i],c=a.completion;if("root"===a.tryLoc)return o("end");if(a.tryLoc<=this.prev){var u=n.call(a,"catchLoc"),h=n.call(a,"finallyLoc");if(u&&h){if(this.prev<a.catchLoc)return o(a.catchLoc,!0);if(this.prev<a.finallyLoc)return o(a.finallyLoc)}else if(u){if(this.prev<a.catchLoc)return o(a.catchLoc,!0)}else{if(!h)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return o(a.finallyLoc)}}}},abrupt:function(t,r){for(var e=this.tryEntries.length-1;e>=0;--e){var o=this.tryEntries[e];if(o.tryLoc<=this.prev&&n.call(o,"finallyLoc")&&this.prev<o.finallyLoc){var i=o;break}}i&&("break"===t||"continue"===t)&&i.tryLoc<=r&&r<=i.finallyLoc&&(i=null);var a=i?i.completion:{};return a.type=t,a.arg=r,i?(this.method="next",this.next=i.finallyLoc,y):this.complete(a)},complete:function(t,r){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&r&&(this.next=r),y},finish:function(t){for(var r=this.tryEntries.length-1;r>=0;--r){var e=this.tryEntries[r];if(e.finallyLoc===t)return this.complete(e.completion,e.afterLoc),O(e),y}},catch:function(t){for(var r=this.tryEntries.length-1;r>=0;--r){var e=this.tryEntries[r];if(e.tryLoc===t){var n=e.completion;if("throw"===n.type){var o=n.arg;O(e)}return o}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,n){return this.delegate={iterator:G(t),resultName:e,nextLoc:n},"next"===this.method&&(this.arg=r),y}},t}("object"==typeof module?module.exports:{});try{regeneratorRuntime=t}catch(r){Function("r","regeneratorRuntime = r")(t)}
},{}],"FOZT":[function(require,module,exports) {
"use strict";function t(t,o){return i(t)||n(t,o)||r(t,o)||e()}function e(){throw new TypeError("Invalid attempt to destructure non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function r(t,e){if(t){if("string"==typeof t)return o(t,e);var r=Object.prototype.toString.call(t).slice(8,-1);return"Object"===r&&t.constructor&&(r=t.constructor.name),"Map"===r||"Set"===r?Array.from(t):"Arguments"===r||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(r)?o(t,e):void 0}}function o(t,e){(null==e||e>t.length)&&(e=t.length);for(var r=0,o=new Array(e);r<e;r++)o[r]=t[r];return o}function n(t,e){if("undefined"!=typeof Symbol&&Symbol.iterator in Object(t)){var r=[],o=!0,n=!1,i=void 0;try{for(var a,c=t[Symbol.iterator]();!(o=(a=c.next()).done)&&(r.push(a.value),!e||r.length!==e);o=!0);}catch(s){n=!0,i=s}finally{try{o||null==c.return||c.return()}finally{if(n)throw i}}return r}}function i(t){if(Array.isArray(t))return t}Object.defineProperty(exports,"__esModule",{value:!0}),exports.localstorageTest=u,exports.multipleNetworkCheck=l,exports.formatDomainList=d,exports.setCookie=p,exports.getCookie=g,exports.testCookie=m,exports.testCookieDomain=f,exports.getLocalStorage=v,exports.isNumeric=exports.isPresent=exports.getParams=void 0;var a=function(e){return e?(/^[?#]/.test(e)?e.slice(1):e).split("&").reduce(function(e,r){var o=t(r.split("="),2),n=o[0],i=o[1];return e[n]=i?decodeURIComponent(i.replace(/\+/g," ")):"",e},{}):{}};exports.getParams=a;var c=function(t,e){return t in e&&e[t]};exports.isPresent=c;var s=function(t){return parseInt(t)-0==parseInt(t)};function u(){try{return localStorage.setItem("test","test"),localStorage.removeItem("test"),!0}catch(t){return!1}}function l(){return Object.keys(window.tdl.domain).length>1}function d(){"string"==typeof window.tdl.domain&&(window.tdl.domain={default:window.tdl.domain})}function m(){document.cookie="cookie_test=test";var t=-1!==document.cookie.indexOf("cookie_test=");return document.cookie="cookie_test=;max-age=0",t}function f(t){document.cookie="tunesdktest=test; domain="+t+"; max-age=60; path=/;";var e=-1!==document.cookie.indexOf("tunesdktest=");return document.cookie="tunesdktest=;max-age=0;",e}function p(t,e,r,o){try{var n="";if(o){var i=new Date;i.setTime(i.getTime()+24*o*60*60*1e3),n="; expires="+i.toUTCString()}var a="";return r&&(a="; domain=."+r),document.cookie=t+"="+(e||"")+a+n+"; path=/;",!0}catch(c){return!1}}function g(t,e){for(var r=[],o=decodeURIComponent(document.cookie).split(";"),n=0;n<o.length;n++){var i=o[n].split("=");(i[0].trim()==t||!1===e&&i[0].trim().includes(t))&&r.push(i[1].trim())}return r}function v(t,e){var r=[];if(!0===e){var o=window.localStorage.getItem(t);o&&r.push(o)}else Object.keys(localStorage).filter(function(e){return e.includes(t)}).forEach(function(t){return r.push(localStorage.getItem(t))});return r}exports.isNumeric=s;
},{}],"u1Uw":[function(require,module,exports) {
"use strict";require("regenerator-runtime/runtime");var e=require("./utils");function t(e,t){var n=Object.keys(e);if(Object.getOwnPropertySymbols){var r=Object.getOwnPropertySymbols(e);t&&(r=r.filter(function(t){return Object.getOwnPropertyDescriptor(e,t).enumerable})),n.push.apply(n,r)}return n}function n(e){for(var n=1;n<arguments.length;n++){var o=null!=arguments[n]?arguments[n]:{};n%2?t(Object(o),!0).forEach(function(t){r(e,t,o[t])}):Object.getOwnPropertyDescriptors?Object.defineProperties(e,Object.getOwnPropertyDescriptors(o)):t(Object(o)).forEach(function(t){Object.defineProperty(e,t,Object.getOwnPropertyDescriptor(o,t))})}return e}function r(e,t,n){return t in e?Object.defineProperty(e,t,{value:n,enumerable:!0,configurable:!0,writable:!0}):e[t]=n,e}function o(e,t){var n;if("undefined"==typeof Symbol||null==e[Symbol.iterator]){if(Array.isArray(e)||(n=u(e))||t&&e&&"number"==typeof e.length){n&&(e=n);var r=0,o=function(){};return{s:o,n:function(){return r>=e.length?{done:!0}:{done:!1,value:e[r++]}},e:function(e){throw e},f:o}}throw new TypeError("Invalid attempt to iterate non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}var i,a=!0,c=!1;return{s:function(){n=e[Symbol.iterator]()},n:function(){var e=n.next();return a=e.done,e},e:function(e){c=!0,i=e},f:function(){try{a||null==n.return||n.return()}finally{if(c)throw i}}}}function i(e,t,n,r,o,i,a){try{var c=e[i](a),s=c.value}catch(u){return void n(u)}c.done?t(s):Promise.resolve(s).then(r,o)}function a(e){return function(){var t=this,n=arguments;return new Promise(function(r,o){var a=e.apply(t,n);function c(e){i(a,r,o,c,s,"next",e)}function s(e){i(a,r,o,c,s,"throw",e)}c(void 0)})}}function c(e){return l(e)||f(e)||u(e)||s()}function s(){throw new TypeError("Invalid attempt to spread non-iterable instance.\nIn order to be iterable, non-array objects must have a [Symbol.iterator]() method.")}function u(e,t){if(e){if("string"==typeof e)return d(e,t);var n=Object.prototype.toString.call(e).slice(8,-1);return"Object"===n&&e.constructor&&(n=e.constructor.name),"Map"===n||"Set"===n?Array.from(e):"Arguments"===n||/^(?:Ui|I)nt(?:8|16|32)(?:Clamped)?Array$/.test(n)?d(e,t):void 0}}function f(e){if("undefined"!=typeof Symbol&&Symbol.iterator in Object(e))return Array.from(e)}function l(e){if(Array.isArray(e))return d(e)}function d(e,t){(null==t||t>e.length)&&(t=e.length);for(var n=0,r=new Array(t);n<t;n++)r[n]=e[n];return r}var p="2.0.0.294758";for(tdl.identify=j,tdl.convert=y,(0,e.formatDomainList)();window.tdl.length&&tdl.domain;){var m=window.tdl.shift(),h=m[0],w=m.slice(1),g=m[2],v=m[3];switch(g||(g=function(){}),v||(v=function(){}),h){case"identify":j.apply(void 0,c(w)).then(g).catch(v);break;case"convert":y.apply(void 0,c(w)).then(g).catch(v)}}function y(){return b.apply(this,arguments)}function b(){return(b=a(regeneratorRuntime.mark(function t(){var r,o,i,a,c,s,u,f,l,d,p=arguments;return regeneratorRuntime.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:for(a in r=p.length>0&&void 0!==p[0]?p[0]:{},o=[],i=n(n({},r),(0,e.getParams)(window.location.search)),window.tdl.domain)c=[],s=U(r,a),u=s!=="tdl_"+a,(f=(0,e.getCookie)(s,u)).length>0&&(c=f),u&&0!=c.length||(l=(0,e.getLocalStorage)(s,u)).length>0&&(c=c.concat(l)),d="goal_id"in r||"goal_ref"in r||"goal_name"in r?window.tdl.domain[a]+"/aff_goal?a=lsr&":window.tdl.domain[a]+"/aff_lsr?",o.concat(_(d,c,r)),0==o.length&&o.concat(k(d,r)),0==o.length&&o.concat(O(window.tdl.domain[a],i));return t.abrupt("return",Promise.allSettled(o));case 5:case"end":return t.stop()}},t)}))).apply(this,arguments)}function _(e,t,n){var r=[],i=[];if(t.length>0){var a,c=P(n),s=o(t);try{for(s.s();!(a=s.n()).done;){var u=a.value,f=c.length>0?"&":"";r.push("".concat(e,"transaction_id=").concat(u).concat(f).concat(c))}}catch(m){s.e(m)}finally{s.f()}var l,d=o(r);try{for(d.s();!(l=d.n()).done;){var p=l.value;i.push(S(p))}}catch(m){d.e(m)}finally{d.f()}}return i}function k(t,n){if((0,e.isPresent)("promo_code",n)){var r=P(n);return[S("".concat(t).concat(r))]}return[]}function P(t){var n=!(arguments.length>1&&void 0!==arguments[1])||arguments[1],r="",o=new Set(["offer_ref","offer_id"]);for(var i in t)if((!n||!o.has(i))&&(0,e.isPresent)(i,t)){var a=r.length>0?"&":"",c=encodeURIComponent(i),s=encodeURIComponent(t[i]);r+="".concat(a).concat(c,"=").concat(s)}return r}function S(e){var t=encodeURI(e);return fetch(t,{mode:"cors",headers:{"Tune-SDK-Version":p}})}function O(e,t){e=e.endsWith("/")?e.slice(0,-1):e;var n="".concat(e,"/ping"),r=P(t,!1);return[S(n=""===r?"".concat(n):"".concat(n,"?").concat(r))]}function j(){return x.apply(this,arguments)}function x(){return(x=a(regeneratorRuntime.mark(function t(){var r,o,i,a,c,s,u,f=arguments;return regeneratorRuntime.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:if(r=f.length>0&&void 0!==f[0]?f[0]:{},o=f.length>1&&void 0!==f[1]?f[1]:{},i=(0,e.multipleNetworkCheck)(),a=n(n(n({},r),(0,e.getParams)(window.location.search)),o),!(i&&(0,e.isPresent)("network_id",a)&&(0,e.isPresent)(a.network_id,window.tdl.domain))){t.next=8;break}c=a.network_id,t.next=13;break;case 8:if(i){t.next=12;break}c=Object.keys(window.tdl.domain)[0],t.next=13;break;case 12:return t.abrupt("return");case 13:if(s=U(a,c),null!==window.sessionStorage.getItem(s)){t.next=29;break}if(!(0,e.isPresent)("transaction_id",a)){t.next=19;break}A(a.transaction_id,s),t.next=27;break;case 19:if(!((0,e.isPresent)("aff_id",a)&&(0,e.isNumeric)(a.aff_id)||(0,e.isPresent)("aff_ref",a))||!((0,e.isPresent)("offer_id",a)&&(0,e.isNumeric)(a.offer_id)||(0,e.isPresent)("offer_ref",a))||"transaction_id"in a){t.next=26;break}return t.next=22,I(a,c);case 22:(u=t.sent)&&A(u,s),t.next=27;break;case 26:return t.abrupt("return");case 27:t.next=30;break;case 29:return t.abrupt("return");case 30:case"end":return t.stop()}},t)}))).apply(this,arguments)}function I(e,t){return R.apply(this,arguments)}function R(){return(R=a(regeneratorRuntime.mark(function t(n,r){var o,i,c,s;return regeneratorRuntime.wrap(function(t){for(;;)switch(t.prev=t.next){case 0:for(i in o=window.tdl.domain[r]+"/aff_c?",n)(0,e.isPresent)(i,n)&&(o=o+"&"+i+"="+n[i]);return o+="&format=json",c=function(){var e=a(regeneratorRuntime.mark(function e(){var t,n,r,i;return regeneratorRuntime.wrap(function(e){for(;;)switch(e.prev=e.next){case 0:return t=encodeURI(o),e.next=3,fetch(t,{mode:"cors",headers:{"Tune-SDK-Version":p}});case 3:return n=e.sent,e.next=6,n.json();case 6:return r=e.sent,i=r.response.data.transaction_id,e.abrupt("return",i);case 9:case"end":return e.stop()}},e)}));return function(){return e.apply(this,arguments)}}(),t.next=6,c();case 6:return s=t.sent,t.next=9,s;case 9:return t.abrupt("return",t.sent);case 10:case"end":return t.stop()}},t)}))).apply(this,arguments)}function A(t,n){!0===(0,e.testCookie)()?D(t,n):C(t,n)}function C(e,t){try{window.sessionStorage.setItem(t,e.toString()),window.localStorage.setItem(t,e.toString())}catch(n){console.error(n)}}function D(t,n){try{window.sessionStorage.setItem(n,t.toString())}catch(c){console.error(c)}for(var r=window.location.hostname.split("."),o="",i=r.length-2;i>=0;i--){var a=r.slice(i,r.length).join(".");if(console.log("testing domain: ",a),(0,e.testCookieDomain)(a)){o=a,console.log("found domain: ",o);break}}return""!==o&&(0,e.setCookie)(n,t,o,1825)}function U(t,n){var r="";return(0,e.isPresent)("offer_id",t)&&(0,e.isNumeric)(t.offer_id)?r="_"+t.offer_id:(0,e.isPresent)("offer_ref",t)&&(r="_"+t.offer_ref),"tdl_"+n+r}
},{"regenerator-runtime/runtime":"QVnC","./utils":"FOZT"}]},{},["u1Uw"], null)
//# sourceMappingURL=tune.js.map