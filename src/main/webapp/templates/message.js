// This file was automatically generated by the Soy compiler.
// Please don't edit this file by hand.
// source: src/main/webapp/templates/message.soy

/**
 * @fileoverview Templates in namespace templates.message.
 * @public
 */

goog.provide('templates.message');

goog.requireType('goog.soy');
goog.require('soy');
goog.require('soy.asserts');
goog.require('soydata.VERY_UNSAFE');


/**
 * @param {templates.message.messageBubble.Params} opt_data
 * @param {(?goog.soy.IjData|?Object<string, *>)=} opt_ijData
 * @param {(?goog.soy.IjData|?Object<string, *>)=} opt_ijData_deprecated
 * @return {!goog.soy.data.SanitizedHtml}
 * @suppress {checkTypes}
 */
templates.message.messageBubble = function(opt_data, opt_ijData, opt_ijData_deprecated) {
  opt_ijData = /** @type {!goog.soy.IjData} */ (opt_ijData_deprecated || opt_ijData);
  /** @type {string} */
  var message = soy.asserts.assertType(typeof opt_data.message === 'string', 'message', opt_data.message, 'string');
  return soydata.VERY_UNSAFE.ordainSanitizedHtml('<head' + (goog.DEBUG && soy.$$debugSoyTemplateInfo ? ' data-debug-soy="templates.message.messageBubble src/main/webapp/templates/message.soy:5"' : '') + '><link rel="stylesheet" href="../chat.css"></head><li class="mdc-list-item mdc-list-item--disabled" tabindex="0"' + (goog.DEBUG && soy.$$debugSoyTemplateInfo ? ' data-debug-soy="templates.message.messageBubble src/main/webapp/templates/message.soy:9"' : '') + '><span class="mdc-list-item__text message">' + soy.$$escapeHtml(message) + '</span></li>');
};
/**
 * @typedef {{
 *  message: string,
 * }}
 */
templates.message.messageBubble.Params;
if (goog.DEBUG) {
  templates.message.messageBubble.soyTemplateName = 'templates.message.messageBubble';
}
