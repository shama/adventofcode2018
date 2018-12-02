(function (_, Kotlin) {
  'use strict';
  var lines = Kotlin.kotlin.text.lines_gw00vp$;
  var ArrayList_init = Kotlin.kotlin.collections.ArrayList_init_287e2$;
  var equals = Kotlin.equals;
  var toInt = Kotlin.kotlin.text.toInt_6ic1pp$;
  var Unit = Kotlin.kotlin.Unit;
  var toString = Kotlin.toString;
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main$lambda(res) {
    return res.text();
  }
  function main$lambda_0(input) {
    var lines_0 = lines(input);
    var total = {v: 0};
    var seen = ArrayList_init();
    var tmp$;
    tmp$ = lines_0.iterator();
    loop_label: while (tmp$.hasNext()) {
      var element = tmp$.next();
      action$break: do {
        var sign = element.substring(0, 1);
        if (equals(sign, '')) {
          break action$break;
        }
         else if (equals(sign, '-')) {
          total.v = total.v - toInt(element.substring(1), 10) | 0;
        }
         else {
          total.v = total.v + toInt(element.substring(1), 10) | 0;
        }
        seen.add_11rb$(total.v);
      }
       while (false);
    }
    println('total: ' + toString(total.v));
    return Unit;
  }
  function main(args) {
    window.fetch(new Request('src/DayOne/input.txt')).then(main$lambda).then(main$lambda_0);
  }
  _.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('DayOne', _);
  return _;
}(module.exports, require('kotlin')));
