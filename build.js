const kotlinCompiler = require('@jetbrains/kotlinc-js-api')
const fs = require('fs')
const path = require('path')
const which = process.argv.slice(2)[0]

const SRC = path.join(__dirname, 'src')

if (which) {
  compile(which)
} else {
  fs.readdir(SRC, function (err, files) {
    files.forEach(function (file) {
      compile(file)
    })
  })
}

function compile (name) {
  kotlinCompiler
    .compile({
      output: `./build/${name}.js`,
      sources: [`${__dirname}/src/${name}`],
      sourceMaps: false,
      moduleKind: 'commonjs',
      libraries: []
    })
    .then(() => console.log(`Compiled ${name}`))
}
