(function(g){var window=this;var P5=function(a,b){var c="ytp-miniplayer-button-bottom-right";var d=g.Y?{D:"div",Y:["ytp-icon","ytp-icon-expand-watch-page"]}:{D:"svg",N:{height:"18px",version:"1.1",viewBox:"0 0 22 18",width:"22px"},K:[{D:"g",N:{fill:"none","fill-rule":"evenodd",stroke:"none","stroke-width":"1"},K:[{D:"g",N:{transform:"translate(-1.000000, -3.000000)"},K:[{D:"polygon",N:{points:"0 0 24 0 24 24 0 24"}},{D:"path",N:{d:"M19,7 L5,7 L5,17 L19,17 L19,7 Z M23,19 L23,4.98 C23,3.88 22.1,3 21,3 L3,3 C1.9,3 1,3.88 1,4.98 L1,19 C1,20.1 1.9,21 3,21 L21,21 C22.1,21 23,20.1 23,19 Z M21,19.02 L3,19.02 L3,4.97 L21,4.97 L21,19.02 Z",
fill:"#fff","fill-rule":"nonzero"}}]}]}]};var e="Open video page";a.O().fa("kevlar_miniplayer_expand_top")&&(c="ytp-miniplayer-button-top-left",d=g.Y?{D:"div",Y:["ytp-icon","ytp-icon-expand-miniplayer"]}:{D:"svg",N:{height:"24px",version:"1.1",viewBox:"0 0 24 24",width:"24px"},K:[{D:"g",N:{fill:"none","fill-rule":"evenodd",stroke:"none","stroke-width":"1"},K:[{D:"g",N:{transform:"translate(12.000000, 12.000000) scale(-1, 1) translate(-12.000000, -12.000000) "},K:[{D:"path",N:{d:"M19,19 L5,19 L5,5 L12,5 L12,3 L5,3 C3.89,3 3,3.9 3,5 L3,19 C3,20.1 3.89,21 5,21 L19,21 C20.1,21 21,20.1 21,19 L21,12 L19,12 L19,19 Z M14,3 L14,5 L17.59,5 L7.76,14.83 L9.17,16.24 L19,6.41 L19,10 L21,10 L21,3 L14,3 Z",
fill:"#fff","fill-rule":"nonzero"}}]}]}]},e="Expand");g.S.call(this,{D:"button",Y:["ytp-miniplayer-expand-watch-page-button","ytp-button",c],N:{title:"{{title}}","data-tooltip-target-id":"ytp-miniplayer-expand-watch-page-button"},K:[d]});var f=this;this.U=a;this.ka("click",this.onClick,this);this.ia("title",g.WL(a,e,"i"));g.me(this,function(){return g.qM(b.Xa(),f.element)})},Q5=function(a){g.S.call(this,{D:"div",
I:"ytp-miniplayer-ui"});this.player=a;this.H=!1;this.G=this.w=this.u=void 0;this.L(a,"minimized",this.lI);this.L(a,"onStateChange",this.QO)},R5=function(a){g.MK.call(this,a);
this.o=new Q5(this.player);this.o.hide();g.zK(this.player,this.o.element,4);a.app.H.o&&(this.load(),g.L(g.fK(a),"ytp-player-minimized",!0))};
g.r(P5,g.S);P5.prototype.onClick=function(){this.U.ma("onExpandMiniplayer")};g.r(Q5,g.S);g.h=Q5.prototype;
g.h.show=function(){this.u=new g.$m(this.kI,null,this);this.u.start();if(!this.H){this.C=new g.RP(this.player,this);g.C(this,this.C);g.zK(this.player,this.C.element,4);this.C.B=.6;this.R=new g.SO(this.player);g.C(this,this.R);this.A=new g.S({D:"div",I:"ytp-miniplayer-scrim"});g.C(this,this.A);this.A.ba(this.element);this.L(this.A.element,"click",this.VA);var a=new g.S({D:"button",Y:["ytp-miniplayer-close-button","ytp-button"],N:{"aria-label":"Close"},K:[g.pL()]});g.C(this,a);a.ba(this.A.element);
this.L(a.element,"click",this.nz);a=new P5(this.player,this);g.C(this,a);a.ba(this.A.element);this.B=new g.S({D:"div",I:"ytp-miniplayer-controls"});g.C(this,this.B);this.B.ba(this.A.element);this.L(this.B.element,"click",this.VA);var b=new g.S({D:"div",I:"ytp-miniplayer-button-container"});g.C(this,b);b.ba(this.B.element);a=new g.S({D:"div",I:"ytp-miniplayer-play-button-container"});g.C(this,a);a.ba(this.B.element);var c=new g.S({D:"div",I:"ytp-miniplayer-button-container"});g.C(this,c);c.ba(this.B.element);
this.M=new g.pN(this.player,this,!1);g.C(this,this.M);this.M.ba(b.element);b=new g.lN(this.player,this);g.C(this,b);b.ba(a.element);this.J=new g.pN(this.player,this,!0);g.C(this,this.J);this.J.ba(c.element);this.G=new g.pO(this.player,this);g.C(this,this.G);this.G.ba(this.A.element);this.w=new g.tM(this.player,this);g.C(this,this.w);g.zK(this.player,this.w.element,4);this.F=new g.S({D:"div",I:"ytp-miniplayer-buttons"});g.C(this,this.F);g.zK(this.player,this.F.element,4);a=new g.S({D:"button",Y:["ytp-miniplayer-close-button",
"ytp-button"],N:{"aria-label":"Close"},K:[g.pL()]});g.C(this,a);a.ba(this.F.element);this.L(a.element,"click",this.nz);a=new g.S({D:"button",Y:["ytp-miniplayer-replay-button","ytp-button"],N:{"aria-label":"Close"},K:[g.EL()]});g.C(this,a);a.ba(this.F.element);this.L(a.element,"click",this.HM);this.L(this.player,"presentingplayerstatechange",this.mI);this.L(this.player,"appresize",this.lt);this.L(this.player,"fullscreentoggled",this.lt);this.lt();this.H=!0}0!=this.player.getPlayerState()&&g.S.prototype.show.call(this);
this.w.show();this.player.unloadModule("annotations_module")};
g.h.hide=function(){this.u&&(this.u.dispose(),this.u=void 0);g.S.prototype.hide.call(this);this.player.app.H.o||(this.H&&this.w.hide(),this.player.loadModule("annotations_module"))};
g.h.X=function(){this.u&&(this.u.dispose(),this.u=void 0);g.S.prototype.X.call(this)};
g.h.nz=function(){this.player.stopVideo();this.player.ma("onCloseMiniplayer")};
g.h.HM=function(){this.player.playVideo()};
g.h.VA=function(a){if(a.target==this.A.element||a.target==this.B.element)g.T(this.player.O().experiments,"kevlar_miniplayer_play_pause_on_scrim")?g.vC(g.hK(this.player))?this.player.pauseVideo():this.player.playVideo():this.player.ma("onExpandMiniplayer")};
g.h.lI=function(){g.L(g.fK(this.player),"ytp-player-minimized",this.player.app.H.o)};
g.h.kI=function(){g.xM(this.w);this.G.w();this.u&&this.u.start()};
g.h.mI=function(a){g.X(a.state,32)&&this.C.hide()};
g.h.lt=function(){g.OM(this.w,0,g.eK(this.player).getPlayerSize().width,!1);this.w.Qu()};
g.h.QO=function(a){this.player.app.H.o&&(0==a?this.hide():this.show())};
g.h.Xa=function(){return this.C};
g.h.uc=function(){return!1};
g.h.Vd=function(){return!1};
g.h.Fj=function(){return!1};
g.h.Du=function(){};
g.h.fi=function(){};
g.h.Qk=function(){};
g.h.Sl=function(){return null};
g.h.kt=function(){return new g.Zg(0,0,0,0)};
g.h.handleGlobalKeyDown=function(){return!1};
g.h.handleGlobalKeyUp=function(){return!1};
g.h.ak=function(a,b,c,d,e){var f=0,k=d=0,l=g.uh(a);if(b){c=g.nn(b,"ytp-prev-button")||g.nn(b,"ytp-next-button");var m=g.nn(b,"ytp-play-button"),n=g.nn(b,"ytp-miniplayer-expand-watch-page-button");c?f=k=12:m?(b=g.rh(b,this.element),k=b.x,f=b.y-12):n&&(k=g.nn(b,"ytp-miniplayer-button-top-left"),f=g.rh(b,this.element),b=g.uh(b),k?(k=8,f=f.y+40):(k=f.x-l.width+b.width,f=f.y-20))}else k=c-l.width/2,d=25+(e||0);b=g.eK(this.player).getPlayerSize().width;e=f+(e||0);l=g.td(k,0,b-l.width);e?(a.style.top=e+
"px",a.style.bottom=""):(a.style.top="",a.style.bottom=d+"px");a.style.left=l+"px"};
g.h.showControls=function(){};
g.h.mt=function(){};
g.h.dg=function(){};g.r(R5,g.MK);R5.prototype.create=function(){};
R5.prototype.Qf=function(){return!1};
R5.prototype.load=function(){this.player.hideControls();this.o.show()};
R5.prototype.unload=function(){this.player.showControls();this.o.hide()};g.aL.miniplayer=R5;})(_yt_player);
