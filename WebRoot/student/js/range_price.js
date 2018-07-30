(function ($) {
    "use strict";
    !function () {
        function e(e, t) {
            for (var n = t.length; n--; )
                e(t[n])
        }

        function t(e, t) {
            for (var n = [], r = 0; r < t.length; r++)
                e(t[r]) && n.push(t[r]);
            return n
        }

        function n(t, n, r) {
            return e(function (e) {
                n = t(n, e)
            }, r), n
        }

        function r(e) {
            var t = Array.prototype.slice.call(arguments, 1);
            return function () {
                return e.apply(this, t.concat(Array.prototype.slice.call(arguments)))
            }
        }

        function u() {
            var e = arguments;
            return function () {
                return n(function (e, t) {
                    return t(e)
                }, arguments[0], e)
            }
        }

        function a(e) {
            return e.apply(this, arguments)
        }

        function i(e, n) {
            return n.querySelector ? n.querySelector('input[name="' + e + '"]') : t(function (t) {
                return "INPUT" === t.tagName && t.getAttribute("name") === e
            }, n.children)[0]
        }

        function o(e, n) {
            return n.querySelector ? n.querySelector('.slider[data-name="' + e + '"]') : t(function (t) {
                return v("slider", t) && t.getAttribute("data-name") === e
            }, n.children)[0]
        }

        function c(e, t, n) {
            var r = document.createElement("input");
            return r.setAttribute("type", "hidden"), r.setAttribute("name", e), r.setAttribute("value", t), n.appendChild(r), r
        }

        function m(e, t, n) {
            var r = document.createElement("div");
            return r.className = "slider", r.setAttribute("data-name", e), r.setAttribute("data-value", t), r.setAttribute("tabindex", 0), n.appendChild(r), r
        }

        function l(e) {
            return e.querySelectorAll ? e.querySelectorAll(".range > .slider") : t(s, e.getElementsByClassName("slider"))
        }

        function d(e) {
            return e.querySelectorAll ? e.querySelectorAll(".range > input") : t(f, e.getElementsByTagName("input"))
        }

        function s(e) {
            return v("slider", e) && e.parentNode && v("range", e.parentNode)
        }

        function f(e) {
            return "INPUT" === e.tagName && e.parentNode && v("range", e.parentNode)
        }

        function v(e, t) {
            return t.classList ? t.classList.contains(e) : ~(" " + t.className + " ").replace(/[\t\n\f\r]/g, " ").indexOf(" " + e + " ")
        }

        function p(e) {
            return e || window.event
        }

        function g(e) {
            e.preventDefault ? e.preventDefault() : e.returnValue = !1
        }

        function A(e, t, n) {
            n.addEventListener ? n.addEventListener(e, t) : n.attachEvent(e, t)
        }

        function b(e, t, n) {
            n.removeEventListener ? n.removeEventListener(e, t) : n.detachEvent(e, t)
        }

        function h(e, t) {
            var n = (t - e.rangeXStart) / e.rangeWidth;
            return n * e.width + e.min
        }

        function y(e, t) {
            return t < e.min ? e.min : t > e.max ? e.max : Math.round((t - e.min) / e.step) * e.step + e.min
        }

        function E(e) {
            var t = 0;
            do
                t += e.offsetLeft;
            while (e = e.offsetParent);
            return t
        }

        function N(e, t, n, r) {
            if (n > t.max ? n = t.max : n < t.min && (n = t.min), r || n !== t.value) {
                var u = 100 * (n - t.min) / t.width;
                if (e.style.left = u + "%", e.setAttribute("data-value", n), t.input.setAttribute("value", n), t.value = n, !r) {
                    var a = document.createEvent("HTMLEvents");
                    a.initEvent("change", !0, !0), e.dispatchEvent(a)
                }
            }
        }

        function w(e) {
            var t = e.parentNode,
                    n = E(t),
                    r = t.offsetWidth,
                    u = 0 | Number(t.getAttribute("data-min")),
                    a = t.getAttribute("data-max");
            a = null == a ? 100 : Number(a);
            var o = Number(t.getAttribute("data-step")) || 1,
                    c = e.getAttribute("data-value"),
                    m = e.getAttribute("data-name"),
                    l = i(m, t),
                    d = {
                        min: u,
                        max: a,
                        width: a - u,
                        step: o,
                        value: c,
                        name: m,
                        rangeXStart: n,
                        rangeWidth: r,
                        input: l,
                        range: t
                    };
            return d.value = y(d, null == c ? u > a ? u : (a + u) / 2 : Number(c)), d
        }

        function S(e) {
            if (e = p(e), s(e.target)) {
                g(e);
                var t = e.target,
                        n = w(t),
                        r = function (e) {
                            e = p(e), b("mouseup", r, document.documentElement), b("mousemove", u, document.documentElement)
                        },
                        u = function (e) {
                            e = p(e);
                            var r = h(n, e.pageX),
                                    u = y(n, r);
                            n.value !== u && N(t, n, u)
                        };
                A("mouseup", r, document.documentElement), A("mousemove", u, document.documentElement)
            }
        }

        function L(e) {
            if (e = p(e), (37 === e.keyCode || 39 === e.keyCode) && s(e.target)) {
                g(e);
                var t = e.target,
                        n = w(t),
                        r = 37 === e.keyCode ? -1 : 1;
                N(t, n, n.value + r)
            }
        }

        function q(e) {
            var t = w(e);
            t.input || (t.input = c(t.name, t.value, t.range)), N(e, t, t.value, !0)
        }

        function x(e) {
            var t = e.getAttribute("name"),
                    n = e.parentNode,
                    r = o(t, n);
            r || q(m(t, e.getAttribute("value"), n))
        }
        A("mousedown", S, document.documentElement), A("keydown", L, document.documentElement);
        var C = r(e, q),
                k = r(e, x);
        A("DOMContentLoaded", r(e, a, [u(C, r(l, document)), u(k, r(d, document))]), window)
    }();
})(jQuery);