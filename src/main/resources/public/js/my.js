/* my own JavaScript. (c) 2017 Thomas Woehlke */


function centerImage(object, winWidth, intext) {
    var intextFigures = object.find('figure'),
        float = object.data('float');

    if(winWidth < 768) {
        if(intext)
            object.removeClass('center-block').removeClass('pull-left').removeClass('pull-right').addClass('intext');
        jQuery(intextFigures).each(function() {
            jQuery(this).removeClass('center-block').removeClass('pull-left').removeClass('pull-right').addClass('center-block');
        });
    } else if (winWidth >= 768) {
        if(intext)
            object.removeClass('center-block').removeClass('pull-left').removeClass('pull-right').addClass(float);
        jQuery( intextFigures ).each(function() {
            jQuery(this).removeClass('center-block').removeClass('pull-left').removeClass('pull-right').addClass(float);
        });
    }
}
jQuery(function() {
    var winWidth = viewportSize.getWidth(),
        carousel = jQuery('.carousel');
    textmedia = jQuery('.textmedia');

    if (carousel.length) {
        jQuery('.carousel-inner .item:first-of-type').addClass( 'active' );
    }
    if (textmedia.length) {
        jQuery('.textmedia .intext').each(function(){
            centerImage(jQuery(this), winWidth, true);
        });
        jQuery('.textmedia .noWrap').each(function(){
            centerImage(jQuery(this), winWidth, false);
        });

        jQuery(window).resize(function() {
            var winWidth = viewportSize.getWidth();
            jQuery('.textmedia .intext').each(function(){
                centerImage(jQuery(this), winWidth, true);
            });
            jQuery('.textmedia .noWrap').each(function(){
                centerImage(jQuery(this), winWidth, false);
            });
        });

        jQuery('.carousel-inner img').removeAttr('width').removeAttr('height');

    }

    var navBarHeight = $('#main-navbar').outerHeight(),
        footerHeight = $('#page-footer').outerHeight();

    if ( $('#main-navbar').hasClass('navbar-fixed-top') ) {
        jQuery('body').css('padding-top', (navBarHeight-1)+'px');
    }

    if ( $('#page-footer').hasClass('sticky-footer') ) {
        jQuery('body').css('padding-bottom', footerHeight+'px');
    }
    if(winWidth < 768) {
        var $menuLeft = jQuery('#bs-navbar-collapse-1 ul.navbar-left');
        var $menuRight = jQuery('#bs-navbar-collapse-1 ul.navbar-right');
        if ( $menuLeft.length ) {
            $menuLeft.removeAttr('class');
            $menuLeft.find( 'ul' ).removeAttr('class');
            jQuery($menuLeft.find( 'li' )).each(function(){
                if ( jQuery(this).hasClass('active') || jQuery(this).hasClass('Selected') ) {
                    jQuery(this).removeAttr('class').addClass('Selected');
                }
            });
            $menuLeft.find( 'li a.dropdown-toggle' ).removeAttr('data-toggle').removeAttr('class');
            $menuLeft.wrap( '<nav id=\'menu-left\' class=\'padd-menu\'></nav>' );
            $('.navbar-header button').removeAttr('data-toggle data-target')
                .removeClass('collapsed')
                .wrap( '<a id="lml" href=\'#menu-left\'></a>' );
        }
        if ( $menuRight.length ) {
            $('.navbar-header button').css('float','none');
            $menuRight.removeAttr('class');
            $menuRight.find( 'ul' ).removeAttr('class');
            jQuery($menuRight.find( 'li' )).each(function(){
                if ( jQuery(this).hasClass('active') || jQuery(this).hasClass('Selected')) {
                    jQuery(this).removeAttr('class').addClass('Selected');
                }
            });
            $menuRight.find( 'li a.dropdown-toggle' ).removeAttr('data-toggle').removeAttr('class');
            $menuRight.wrap( '<nav id=\'menu-right\' class=\'padd-menu\'></nav>' );
        }
    }
    /*  mmenu main/left config */
    if(winWidth < 768 && $menuLeft.length) {
        $('#menu-left').mmenu({
            'extensions': [
                'pagedim-black',
                'theme-dark',
                'effect-slide-menu',
                'shadow-page',
                'shadow-panels'
            ],
            'keyboardNavigation': true,
            'screenReader': true,
            'counters': false,
            'navbar': {
                'title': 'btw17 Kandidaten'
            },
            'navbars': [{
                'position': 'top',
                'content': [
                    'prev',
                    'title',
                    'close'
                ]
            },{
                'position': 'bottom',
                'content': [
                    '<a class="glyphicon glyphicon-search" href="/information/suche/"></a>',
                    '<a class="fa fa-envelope" href="/kontakt/"></a>',
                ]
            }]
        });
    } /*  mmenu right config */
    if(winWidth < 768 && $menuRight.length) {
        $('#lml')
            .after('<a id=\'rml\' href=\'#menu-right\'><i class=\'fa fa-chevron-circle-down fa-lg pull-right navbar-toggle\' aria-hidden=\'true\'></i></a>');
        $('#menu-right').mmenu({
            'offCanvas': {
                'position': 'right'
            },
            'extensions': [
                'pagedim-black',
                'theme-dark',
                'effect-slide-menu',
                'shadow-page',
                'shadow-panels'
            ],
            'keyboardNavigation': true,
            'screenReader': true,
            'counters': false,
            'navbar': {
                'title': 'btw17 Kandidaten'
            },
        });
    }	if(winWidth < 768) {
        jQuery('.caret').remove();
    }
    jQuery('.page-content a').tooltip({placement:'top'});
    jQuery('[data-toggle="tooltip"]').tooltip()
    jQuery('.sidebar .has-sub.active ul.sidebar-sub').show();
    lightbox.option({
        'resizeDuration': 200,
        'wrapAround': true,
        'albumLabel' : 'Bild %1 von %2'
    });

    if (location.hash) jQuery(location.hash).collapse('show');
    jQuery('.animated').viewportChecker({offset: 1});
});
