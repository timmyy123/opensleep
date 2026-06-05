!
function(e) {
  function t(t) {
    for (var s, n, r = t[0], l = t[1], c = t[2], d = 0, u = []; d < r.length; d++) n = r[d],
    Object.prototype.hasOwnProperty.call(o, n) && o[n] && u.push(o[n][0]),
    o[n] = 0;
    for (s in l) Object.prototype.hasOwnProperty.call(l, s) && (e[s] = l[s]);
    for (h && h(t); u.length;) u.shift()();
    return a.push.apply(a, c || []),
    i()
  }
  function i() {
    for (var e, t = 0; t < a.length; t++) {
      for (var i = a[t], s = !0, r = 1; r < i.length; r++) {
        var l = i[r];
        0 !== o[l] && (s = !1)
      }
      s && (a.splice(t--, 1), e = n(n.s = i[0]))
    }
    return e
  }
  var s = {},
  o = {
    0 : 0
  },
  a = [];
  function n(t) {
    if (s[t]) return s[t].exports;
    var i = s[t] = {
      i: t,
      l: !1,
      exports: {}
    };
    return e[t].call(i.exports, i, i.exports, n),
    i.l = !0,
    i.exports
  }
  n.m = e,
  n.c = s,
  n.d = function(e, t, i) {
    n.o(e, t) || Object.defineProperty(e, t, {
      enumerable: !0,
      get: i
    })
  },
  n.r = function(e) {
    "undefined" != typeof Symbol && Symbol.toStringTag && Object.defineProperty(e, Symbol.toStringTag, {
      value: "Module"
    }),
    Object.defineProperty(e, "__esModule", {
      value: !0
    })
  },
  n.t = function(e, t) {
    if (1 & t && (e = n(e)), 8 & t) return e;
    if (4 & t && "object" == typeof e && e && e.__esModule) return e;
    var i = Object.create(null);
    if (n.r(i), Object.defineProperty(i, "default", {
      enumerable: !0,
      value: e
    }), 2 & t && "string" != typeof e) for (var s in e) n.d(i, s,
    function(t) {
      return e[t]
    }.bind(null, s));
    return i
  },
  n.n = function(e) {
    var t = e && e.__esModule ?
    function() {
      return e.
    default
    }:
    function() {
      return e
    };
    return n.d(t, "a", t),
    t
  },
  n.o = function(e, t) {
    return Object.prototype.hasOwnProperty.call(e, t)
  },
  n.p = "";
  var r = window.webpackJsonp = window.webpackJsonp || [],
  l = r.push.bind(r);
  r.push = t,
  r = r.slice();
  for (var c = 0; c < r.length; c++) t(r[c]);
  var h = l;
  a.push([0, 1]),
  i()
} ([function(e, t, i) {
  "use strict";
  Object.defineProperty(t, "__esModule", {
    value: !0
  }),
  t.game = void 0;
  var s = i(1),
  o = i(2),
  a = {
    title: "Agent Sheep",
    type: s.CANVAS,
    scale: {
      width: "100%",
      height: "100%"
    },
    scene: o.
  default,
    physics: {
    default:
      "arcade",
      arcade: {
        debug: !1
      }
    },
    canvas: document.getElementById("gameCanvas"),
    backgroundColor: "#96b1f3"
  };
  console.log("beforeGame"),
  t.game = new s.Game(a),
  window.addEventListener("resize", (function() {
    console.log("window resized"),
    t.game.scale.refresh()
  }))
},
,
function(e, t, i) {
  "use strict";
  Object.defineProperty(t, "__esModule", {
    value: !0
  });
  var s = i(3);
  t.
default = [s.GameScene]
},
function(e, t, i) {
  "use strict";
  var s, o = this && this.__extends || (s = function(e, t) {
    return (s = Object.setPrototypeOf || {
      __proto__: []
    }
    instanceof Array &&
    function(e, t) {
      e.__proto__ = t
    } ||
    function(e, t) {
      for (var i in t) Object.prototype.hasOwnProperty.call(t, i) && (e[i] = t[i])
    })(e, t)
  },
  function(e, t) {
    function i() {
      this.constructor = e
    }
    s(e, t),
    e.prototype = null === t ? Object.create(t) : (i.prototype = t.prototype, new i)
  });
  Object.defineProperty(t, "__esModule", {
    value: !0
  }),
  t.GameScene = void 0;
  var a = i(4),
  n = i(5),
  r = i(0),
  l = i(6),
  lastRun = -1,
  c = function(e) {
    function t() {
      var t, i = e.apply(this, arguments) || this;
      return i.KEYS = {
        sprite_sheep: "sheep",
        sprite_ground: "ground",
        sprite_wolf: "wolf",
        sprite_fence: "fence",
        bkg: "bkg",
        anim_run: "run",
        anim_jump: "jumpSlow",
        data_obstacle_jumped: "data_jumped",
        cloud1: "cloud1",
        cloud2: "cloud2"
      },
      i.gameStarted = !1,
      i.total_obstacle_count = n.GAME_CONFIG.total_obstacles_to_jump * JSON.parse((null === (t = globalThis.Captcha) || void 0 === t ? void 0 : t.getDifficulty()) || 1),
      i.score = i.total_obstacle_count,
      i
    }
    return o(t, e),
    t.prototype.preload = function() {
      console.log(r.game.scale.height + " vs " + window.innerHeight),
      console.log(r.game.scale.width + " vs " + window.innerWidth),
      this.load.spritesheet(this.KEYS.sprite_sheep, "assets/sprites/sheep-small.png", {
        frameWidth: 100,
        frameHeight: 103,
        endFrame: 3
      }),
      this.load.image(this.KEYS.sprite_ground, "assets/sprites/ground.png"),
      this.load.image(this.KEYS.sprite_wolf, "assets/sprites/vlk.png"),
      this.load.image(this.KEYS.sprite_fence, "assets/sprites/fence.png"),
      this.load.image(this.KEYS.bkg, "assets/sprites/bkg.png"),
      this.load.image(this.KEYS.cloud1, "assets/sprites/mrak1.png"),
      this.load.image(this.KEYS.cloud2, "assets/sprites/mrak2.png"),
      console.log("preload() finished")
    },
    t.prototype.create = function() {
      var e, t, i, s;
      console.log("Create - initial checks. Captcha interface: " + globalThis.Captcha + ", Captcha?.userInteracted: " + (null === (e = globalThis.Captcha) || void 0 === e ? void 0 : e.userInteracted) + ", Captcha?.getDifficulty(): " + JSON.stringify(null === (t = globalThis.Captcha) || void 0 === t ? void 0 : t.getDifficulty())),
      r.game.scale.setGameSize(window.innerWidth, window.innerHeight),
      null === (i = globalThis.Captcha) || void 0 === i || i.userInteracted(),
      console.log("Width: " + a.getGameWidth(this) + ", Height: " + a.getGameHeight(this)),
      0 === a.getGameWidth(this) && 0 === a.getGameHeight(this) && (r.game.scale.refresh(), console.log("Refreshing game scale"), console.log("parentsize: " + this.game.scale.parentSize + " " + this.game.scale.gameSize + " " + this.game.canvas.width + "x" + this.game.canvas.height), r.game.scale.setGameSize(window.innerWidth, window.innerHeight), null === (s = globalThis.Captcha) || void 0 === s || s.unsolved());
      this.GROUND = {
        x: 0,
        y: a.getGameHeight(this) - 60,
        y_invisible: a.getGameHeight(this) - 15,
        width: 2 * a.getGameWidth(this),
        height: 60
      },
      this.SHEEP = {
        x: 80,
        y: this.GROUND.y_invisible
      },
      this.initBackground(),
      this.initScore(),
      this.initGround(),
      this.initPlayer(),
      this.initObstacles(),
      this.initCollisions(),
      this.clouds = new l.Clouds(this),
      this.physics.add.collider(this.player, this.groundInvisibleLayer),
      this.cursors = this.input.keyboard.createCursorKeys(),
      console.log("create() finished")
    },
    t.prototype.update = function(time, i) {
      var s, o;
      if (lastRun == -1 || time - lastRun >= 17) {
          lastRun = time;
          e.prototype.update.call(this, t, i),
          this.clouds.update(),
          this.gameStarted ? (console.log("update running game"), this.groundSprite.tilePositionX += n.GAME_CONFIG.speed, this.player.setVelocityX(0), this.activeObstaclesGroup.incX( - n.GAME_CONFIG.speed), this.checkObstaclesVisibility(), this.maybeAddObstacle(), this.shouldJump() ? (null === (s = globalThis.Captcha) || void 0 === s || s.userInteracted(), this.player.setVelocityY( - n.GAME_CONFIG.jump_height), this.player.play(this.KEYS.anim_jump)) : this.player.body.touching.down && this.player.play(this.KEYS.anim_run, !0), this.checkIfJumpedOverObstacle()) : this.shouldJump() && (null === (o = globalThis.Captcha) || void 0 === o || o.userInteracted(), this.gameStarted = !0, this.player.play(this.KEYS.anim_run), this.addObstacleFromPool(1500))
      }
    },
    t.prototype.initBackground = function() {
      var e = this.add.image(this.cameras.main.width / 2, this.cameras.main.height / 2, this.KEYS.bkg),
      t = this.cameras.main.width / e.width,
      i = this.cameras.main.height / e.height,
      s = Math.max(t, i);
      e.setScale(s).setScrollFactor(0)
    },
    t.prototype.initGround = function() {
      this.groundInvisibleLayer = this.physics.add.staticGroup(),
      this.groundInvisibleLayer.create(0, this.GROUND.y_invisible, null, null, !1).setScale(5, .5).setOrigin(0, 0).refreshBody(),
      this.groundSprite = this.add.tileSprite(this.GROUND.x, this.GROUND.y, this.GROUND.width, this.GROUND.height, this.KEYS.sprite_ground).setOrigin(0, 0),
      console.log("initGround visible x:" + this.GROUND.x + " y:" + this.GROUND.y),
      console.log("initGround invisible x:" + this.GROUND.x + " y:" + this.GROUND.y_invisible)
    },
    t.prototype.initPlayer = function() {
      this.anims.create({
        key: this.KEYS.anim_run,
        frames: this.anims.generateFrameNumbers(this.KEYS.sprite_sheep, {
          start: 0,
          end: 3
        }),
        frameRate: 10,
        repeat: -1
      }),
      this.anims.create({
        key: this.KEYS.anim_jump,
        frames: this.anims.generateFrameNumbers(this.KEYS.sprite_sheep, {
          start: 1,
          end: 2
        }),
        frameRate: 6
      }),
      console.log("initPlayer x:" + this.SHEEP.x + " y:" + this.SHEEP.y),
      this.player = this.physics.add.sprite(this.SHEEP.x, this.SHEEP.y, this.KEYS.sprite_sheep).setOrigin(0, 1),
      this.player.setBounce(.2),
      this.player.setCollideWorldBounds(!1),
      this.player.setGravityY(1600),
      this.player.setBodySize(.5 * this.player.width, this.player.height, !0)
    },
    t.prototype.initObstacles = function() {
      var e = this;
      this.activeObstaclesGroup = this.add.group({
        removeCallback: function(t) {
          t.setData(e.KEYS.data_obstacle_jumped, !1),
          e.obstaclesPool.add(t)
        }
      }),
      this.obstaclesPool = this.add.group({
        removeCallback: function(t) {
          e.activeObstaclesGroup.add(t)
        }
      }),
      this.getObstacleKeys().map((function(t) {
        e.addObstacleToPool(t),
        e.addObstacleToPool(t)
      }))
    },
    t.prototype.addObstacleToPool = function(e) {
      var t = this.physics.add.sprite(0, this.SHEEP.y, e).setScale(.7).setOrigin(0, 1);
      t.setBodySize(.6 * t.width, t.height, !0),
      t.x = -t.width,
      t.visible = !1,
      t.active = !1,
      t.setImmovable(!0),
      this.obstaclesPool.add(t)
    },
    t.prototype.addObstacleFromPool = function(e) {
      var t;
      this.activeObstaclesGroup.countActive() >= n.GAME_CONFIG.max_obstacles_on_screen || (e || (e = a.getGameWidth(this)), this.obstaclesPool.getLength() && ((t = this.getRandomObstacleFromPool()).x = e, t.active = !0, t.visible = !0, this.obstaclesPool.remove(t)))
    },
    t.prototype.checkObstaclesVisibility = function() {
      var e = this;
      this.activeObstaclesGroup.getChildren().map((function(t) {
        t.x < -t.width && (console.log("Killing", t), e.activeObstaclesGroup.killAndHide(t), e.activeObstaclesGroup.remove(t))
      }))
    },
    t.prototype.maybeAddObstacle = function() {
      if (! (this.activeObstaclesGroup.countActive() >= n.GAME_CONFIG.max_obstacles_on_screen)) {
        var e = this.activeObstaclesGroup.getChildren().reduce((function(e, t) {
          return e ? t.x > e.x ? t: e: t
        }), null); (!e || e.x < .2 * a.getGameWidth(this)) && this.addObstacleFromPool(a.getGameWidth(this) + Math.random() * a.getGameWidth(this))
      }
    },
    t.prototype.getObstacleKeys = function() {
      return [this.KEYS.sprite_wolf, this.KEYS.sprite_fence]
    },
    t.prototype.getRandomObstacleFromPool = function() {
      var e = this.obstaclesPool.getChildren(),
      t = Math.floor(Math.random() * e.length);
      return console.log("randomObstacleFromPool", t, e.length),
      e[t]
    },
    t.prototype.initCollisions = function() {
      var e = this;
      console.log("initCollisions. Active obstacles: " + this.activeObstaclesGroup.getChildren().length + ", Pool size: " + this.obstaclesPool.getChildren().length),
      this.activeObstaclesGroup.getChildren().length && console.warn("There are active obstacles before game start"),
      this.obstaclesPool.getChildren().map((function(t) {
        e.physics.add.collider(e.player, t, (function(t, i) {
          var s;
          console.log("collision"),
          null === (s = globalThis.Captcha) || void 0 === s || s.userInteracted(),
          e.gameOver()
        }))
      }))
    },
    t.prototype.gameOver = function() {
      this.gameStarted = !1,
      this.scene.restart()
    },
    t.prototype.initScore = function() {
      this.score = this.total_obstacle_count,
      this.scoreText = this.add.text(80, 80, this.getScoreText(this.score), {
        fontSize: "48px"
      })
    },
    t.prototype.lowerScoreByOne = function() {
      this.score -= 1,
      this.scoreText.setText(this.getScoreText(this.score)),
      this.score < 1 && this.gameFinished()
    },
    t.prototype.getScoreText = function(e) {
      return "" + e
    },
    t.prototype.checkIfJumpedOverObstacle = function() {
      var e = this;
      this.activeObstaclesGroup.getChildren().map((function(t) {
        t.x - 1 <= e.player.x && e.player.x >= t.x + 1 && (t.getData(e.KEYS.data_obstacle_jumped) || (t.setData(e.KEYS.data_obstacle_jumped, !0), e.lowerScoreByOne(), console.log("Jumped over")))
      }))
    },
    t.prototype.gameFinished = function() {
      var e;
      null === (e = globalThis.Captcha) || void 0 === e || e.solved()
    },
    t.prototype.shouldJump = function() {
      return (this.cursors.up.isDown || this.input.activePointer.isDown) && this.player.body.touching.down
    },
    t
  } (Phaser.Scene);
  t.GameScene = c
},
function(e, t, i) {
  "use strict";
  Object.defineProperty(t, "__esModule", {
    value: !0
  }),
  t.getGameHeight = t.getGameWidth = void 0;
  t.getGameWidth = function(e) {
    return window.innerWidth
  };
  t.getGameHeight = function(e) {
    return window.innerHeight
  }
},
function(e, t, i) {
  "use strict";
  Object.defineProperty(t, "__esModule", {
    value: !0
  }),
  t.GAME_CONFIG = void 0,
  t.GAME_CONFIG = {
    max_obstacles_on_screen: 2,
    total_obstacles_to_jump: 5,
    speed: 10,
    jump_height: 700
  }
},
function(e, t, i) {
  "use strict";
  Object.defineProperty(t, "__esModule", {
    value: !0
  }),
  t.Clouds = void 0;
  var s = function() {
    function e(e) {
      this.scene = e,
      this.cloud1 = e.add.image(3 * e.cameras.main.width / 4, e.cameras.main.height / 2, e.KEYS.cloud1),
      this.cloud2 = e.add.image(e.cameras.main.width / 5, e.cameras.main.height / 3, e.KEYS.cloud2)
    }
    return e.prototype.update = function() {
      this.cloud1.setX(this.cloud1.x - 7),
      this.cloud2.setX(this.cloud2.x - 5),
      this.cloud1.x < -this.cloud1.width / 2 && (this.cloud1.x = this.scene.cameras.main.width + this.cloud1.width / 2),
      this.cloud2.x < -this.cloud2.width / 2 && (this.cloud2.x = this.scene.cameras.main.width + this.cloud2.width / 2)
    },
    e
  } ();
  t.Clouds = s
}]);